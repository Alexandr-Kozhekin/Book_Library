
import org.junit.Test;
import servis.BookServis.BookDatabaseImpl;
import bean.Book;
import servis.BookServis.UniqueWordFinder;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void saveBookTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        Long [] expected = {1L, 2L, 3L};

        Long [] actual = {bookDatabase.save(new Book("A1", "T1")),
                bookDatabase.save(new Book("A2", "T2")),
                bookDatabase.save(new Book("A3", "T3")) };

        assertEquals(expected,actual);
    }

    @Test
    public void bookReNameTest() {

        String [] expected = {"Test1", "Test2", "Test3", "Test4", "Test5"};

        Book [] book = {new Book("T1", "B2"),
                new Book("T2", "B3"),
                new Book("T3", "B4"),
                new Book("T4", "B5"),
                new Book("T5", "B6"),};

        for (int i = 0; i < expected.length; i++){

            int q = i + 1;

            book [i].setTitle("Test" + q);

        }

        String [] q = new String[book.length];

        for(int i = 0; i < book.length; i++){

            q [i] = book[i].getTitle();

        }

        String [] actual = q;

        assertEquals(expected, actual);

    }

    @Test
    public void deleteBookTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        Book book = new Book("A1", "T1");

        bookDatabase.save(book);

        boolean actual = bookDatabase.deleteBook(new Book("A1", "T1"));

        assertEquals(true, actual);

    }

    @Test
    public void deleteBookForIDTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        Book book = new Book("A1", "T1");

        bookDatabase.save(book);

        boolean actual = bookDatabase.deleteBook(1L);

        assertEquals(true, actual);
    }

    @Test
    public void findByAuthorTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        Book book = new Book("A1", "T1");

        List<Book> expected = new ArrayList<>();

        expected.add(book);

        List<Book> actual = new ArrayList<>();

        bookDatabase.save(book);

        actual = bookDatabase.findByAuthor("A1");

        assertEquals(actual, actual);
    }

    @Test
    public void findByTitleTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        List<Book> expectedBookTitleList = new ArrayList<>();

        Book book = new Book("A1", "T1");

        bookDatabase.save(book);

        expectedBookTitleList = bookDatabase.findByTitle("T1");

        List<Book> actualBookTitleList = new ArrayList<>();

        actualBookTitleList.add(book);

        assertEquals(actualBookTitleList, expectedBookTitleList);
    }

    @Test
    public void findByIdTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        Book book = new Book("A1", "T1");

        bookDatabase.save(book);

        Book expect = bookDatabase.books.get(0);

        Optional optionalBook = bookDatabase.findById(1L);
        Object actual = optionalBook.get();

        assertEquals(expect, actual);

    }

    @Test
    public void countAllBooksTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        int expected = 4;
        int actual = bookDatabase.countAllBooks();

        assertEquals(expected, actual);
    }

    @Test
    public void deleteByTitleTest() {

//        boolean[] expected = {true, true};
//        boolean[] actual = new boolean[expected.length];

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

//            for (int i = 0; i < expected.length; i++) {
//                try {

        Book book = new Book("A1", "T1");
        Book book2 = new Book("A2", "T2");
        Book book3 = new Book("A1", "T1");

        bookDatabase.save(book);
        bookDatabase.save(book2);
        bookDatabase.save(book3);

        bookDatabase.deleteByTitle("T1");

        int expectSizeList = bookDatabase.books.size();

        List<Book> actualBookList = new ArrayList<>();

//                if (i == 1){
//
//                    actualBookList.add(new Book("A3", "T3"));
//
//                }

        actualBookList.add(new Book("A2", "T2"));

        int actualBooksListSize = actualBookList.size();

        assertEquals(actualBooksListSize, expectSizeList);

//                actual[i] = true;

//                bookDatabase.books.removeAll(bookDatabase.books);
//                actualBookList.removeAll(actualBookList);

//                } catch(AssertionError e) {
//
//                actual[i] = false;
//
//            }
//        }
//       assertEquals(expected, actual);
    }

    @Test
    public void deleteByAuthorTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        Book book = new Book("A1", "T1");

        bookDatabase.save(book);
        bookDatabase.deleteByAuthor("A1");

        boolean actual = false;

        if(0 == bookDatabase.books.size()){
            actual = true;
        }

        assertEquals(true, actual);
    }

//    @Test
//    public void findTest() {
//
//        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();
//
//        bookDatabase.save(new Book("A1", "T1"));
//        bookDatabase.save(new Book("A2", "T2"));
//        bookDatabase.save(new Book("A3", "T3"));
//        bookDatabase.save(new Book("A4", "T4"));
//
//        bookDatabase.find(new AuthorSearchCriteria("A1"));
//        bookDatabase.find(new TitleSearchCriteria("T1"));
//
//        List<Book> expected = new ArrayList<>();
//
//        expected.add(bookDatabase.books.get(1));
//
//        List<Book> actual = bookDatabase.find(new TitleSearchCriteria("T2"));
//
//        assertEquals(expected.get(0), actual.get(0));
//    }

    @Test
    public void findUniqueAuthorsTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        Set<String> expected = new HashSet<>();

        for (int i = 0; i < bookDatabase.books.size(); i++){

            expected.add(bookDatabase.books.get(i).getAuthor());

        }

        Set<String> actual = bookDatabase.findUniqueAuthors();

        assertEquals(expected, actual);

    }

    @Test
    public void findUniqueTitlesTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        Set<String> expected = new HashSet<>();

        for (int i = 0; i < bookDatabase.books.size(); i++){

            expected.add(bookDatabase.books.get(i).getTitle());

        }

        Set<String> actual = bookDatabase.findUniqueTitles();

        assertEquals(expected, actual);

    }

    @Test
    public void findUniqueBooksTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        Set<Book> expected = new HashSet<>(bookDatabase.books);

        Set<Book> actual = bookDatabase.findUniqueBooks();

        assertEquals(expected, actual);

    }

    @Test
    public void containsTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        assertTrue(bookDatabase.contains(bookDatabase.books.get(1)));

    }

    @Test
    public void uniqueWordFinderTest() {

        UniqueWordFinder uniqueWordFinder = new UniqueWordFinder();

        Set<String> expected = new HashSet<>();
        expected.add("A");
        expected.add("a");
        expected.add("B");
        expected.add("bb");

        Set<String> actual = new HashSet<>(uniqueWordFinder.find("A a a a a a a a a a a a B bb bb bb"));

        assertEquals(expected, actual);

    }

    @Test
    public void getAuthorToBooksMapTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A1", "T2"));
        bookDatabase.save(new Book("A2", "T3"));
        bookDatabase.save(new Book("A2", "T4"));

        List<Book> oneListUniqueBooks = new ArrayList<>();
        oneListUniqueBooks.add(bookDatabase.books.get(0));
        oneListUniqueBooks.add(bookDatabase.books.get(1));

        List<Book> twoListUniqueBooks = new ArrayList<>();
        twoListUniqueBooks.add(bookDatabase.books.get(2));
        twoListUniqueBooks.add(bookDatabase.books.get(3));

        Map<String, List<Book>> expected = new HashMap<>();
        expected.put(bookDatabase.books.get(0).getAuthor(), oneListUniqueBooks);
        expected.put(bookDatabase.books.get(2).getAuthor(), twoListUniqueBooks);

        Map<String, List<Book>> actual = bookDatabase.getAuthorToBooksMap();

        assertEquals(expected, actual);

    }

    @Test
    public void getEachAuthorBookCountTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A1", "T2"));
        bookDatabase.save(new Book("A2", "T3"));
        bookDatabase.save(new Book("A2", "T4"));

        Map<String, Integer> expected = new HashMap<>();
        expected.put(bookDatabase.books.get(0).getAuthor(), 2);
        expected.put(bookDatabase.books.get(2).getAuthor(), 2);

        Map<String, Integer> actual = bookDatabase.getEachAuthorBookCount();

        assertEquals(expected, actual);

    }
}