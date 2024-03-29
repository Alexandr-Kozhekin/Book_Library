package servis.BookServis;

import bean.Book;
import servis.SearchCriteriaServis.SearchCriteria;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface BookDatabase {

    Long save(Book book);

    boolean deleteBook(Long bookId);

    boolean deleteBook(Book book);

    Optional<Book> findById(Long bookId);

    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

    List<Book> findByYears(String years);

    int countAllBooks();

    void deleteByAuthor(String author);

    void deleteByTitle(String title);

    List<Book> find(SearchCriteria searchCriteria);

    Set<String> findUniqueAuthors();

    Set<String> findUniqueTitles();

    Set<Book> findUniqueBooks();

    boolean contains(Book book);

    Map<String, List<Book>> getAuthorToBooksMap();

    Map<String, Integer> getEachAuthorBookCount();

}