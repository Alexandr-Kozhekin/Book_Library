package servis.BookServis;

import bean.Book;
import servis.SearchCriteriaServis.*;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

import static application.BookLibraryApplication.getConnection;

public class BookDatabaseImpl implements BookDatabase {

    public List<Long> bookID = new ArrayList<>();
    public List<Book> books = new ArrayList<>();

    @Override
    public Long save(Book book) {

        if (bookID.isEmpty()) {

            book.setId(1L);

        } else {

            int index = bookID.size() + 1;
            book.setId((long) index);
        }

        bookID.add(book.getId());
        books.add(book);

        try (Statement statement = getConnection().createStatement()) {

            statement.executeUpdate("INSERT Books(AuthorBook, TittleBook, YearOfIssueBook)"
                    + " VALUES " +
                    "(" + "'" + book.getAuthor() + "', "
                    + "'" + book.getTitle() + "', "
                    + "'" +  book.getYearOfIssue() +"'" +")");

        } catch (SQLException | IOException throwables) {

            throwables.printStackTrace();

        }

        return book.getId();
    }

    @Override
    public boolean deleteBook(Long bookId) {

        if (bookID.contains(bookId)) {

            bookID.remove(bookId);

            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId().equals(bookId)) {

                    books.remove(i);

                    try (Statement statement = getConnection().createStatement()) {

                        statement.executeUpdate("DELETE FROM Books WHERE Id=" + i++ + ";" );

                    } catch (SQLException | IOException throwables) {

                        throwables.printStackTrace();

                    }
                }
            }

            return true;

        } else {

            return false;
        }
    }

    @Override
    public boolean deleteBook(Book book) {

        if (books.contains(book)) {

            bookID.remove(book.getId());
            books.remove(book);

            return true;

        } else {

            return false;
        }
    }

    @Override
    public Optional<Book> findById(Long bookId) {

        return !books.isEmpty() ? Optional.of(books.get(Math.toIntExact(bookId) - 1)) : Optional.empty();
    }

    @Override
    public List<Book> findByAuthor(String author) {

        return books.stream().
                filter(book -> book.getAuthor().equals(author)).
                collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {

        return books.stream().
                filter(book -> book.getTitle().equals(title)).
                collect(Collectors.toList());
    }

    @Override
    public List<Book> findByYears(String years){

        return books.stream().
                filter(book -> book.getYearOfIssue().equals(years)).
                collect(Collectors.toList());
    }

    @Override
    public int countAllBooks() {

        return books.size();
    }

    @Override
    public void deleteByAuthor(String author) {

        for (int i = 0; i < books.size(); ) {

            if (books.get(Math.toIntExact(i)).getAuthor().equals(author)) {

                deleteBook(books.get(i));

            } else {

                i++;

            }
        }
    }

    @Override
    public void deleteByTitle(String title) {

        for (int i = 0; i < books.size(); ) {

            if (books.get(Math.toIntExact(i)).getTitle().equals(title)) {

                deleteBook(books.get(i));

            } else {

                i++;

            }
        }
    }

    @Override
    public List<Book> find(SearchCriteria searchCriteria) {

        List<Book> findBook = new ArrayList<>();

        for (Book book : books){

            if (searchCriteria.match(book)){

                findBook.add(book);

            }
        }

        return findBook;
    }

    @Override
    public Set<String> findUniqueAuthors() {

        return books.stream().
                map(Book::getAuthor).
                collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<String> findUniqueTitles() {

        return books.stream().
                map(Book::getTitle).
                collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<Book> findUniqueBooks() {

        return new HashSet<>(books);
    }

    @Override
    public boolean contains(Book book) {

        if (books.contains(book)) {

            return true;

        } else {

            return false;
        }
    }

    @Override
    public Map<String, List<Book>> getAuthorToBooksMap() {

        Map<String, List<Book>> bookMap = new HashMap<>();

        for (int i = 0; i < books.size(); i++){

            bookMap.put(books.get(i).getAuthor(), findByAuthor(books.get(i).getAuthor()));

        }

        return bookMap;
    }

    @Override
    public Map<String, Integer> getEachAuthorBookCount() {

        Map<String, Integer> bookMap = new HashMap<>();

        Set<String> uniqueAuthors = findUniqueAuthors();

        List<String> uniqueAuthorList = new ArrayList<>(uniqueAuthors);

        for (int i = 0; i < uniqueAuthors.size(); i++){

            Set<Book> uniqueBook = new HashSet<>(findByAuthor(uniqueAuthorList.get(i)));

            bookMap.put(uniqueAuthorList.get(i), uniqueBook.size());

        }

        return bookMap;
    }
}




