import org.junit.Test;
import bean.Book;
import servis.BookServis.BookDatabaseImpl;
import servis.SearchCriteriaServis.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookSearchCriteriaServisTest {

    @Test
    public void authorSearchCriteriaTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A1", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A3", "T4"));

        List<Book> expected = new ArrayList<>();
        expected.add(bookDatabase.books.get(2));
        expected.add(bookDatabase.books.get(3));

        List<Book> actual = bookDatabase.find(new AuthorSearchCriteria("A3"));

        assertEquals(expected, actual);
    }

    @Test
    public void titleSearchCriteriaTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();

        bookDatabase.save(new Book("A1", "T2"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        List<Book> expected = new ArrayList<>();
        expected.add(bookDatabase.books.get(0));
        expected.add(bookDatabase.books.get(1));

        List<Book> actual = bookDatabase.find(new TitleSearchCriteria("T2"));

        assertEquals(expected, actual);

    }

    @Test
    public void yearOfIssueSearchCriteriaTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();
        YearOfIssueSearchCriteria yearOfIssueSearchCriteria = new YearOfIssueSearchCriteria("1993");

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        bookDatabase.books.get(0).setYearOfIssue("1993");

        assertTrue(yearOfIssueSearchCriteria.match(bookDatabase.books.get(0)));

    }

    @Test
    public void orSearchCriteriaTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();
        OrSearchCriteria orSearchCriteria = new OrSearchCriteria(
                new AuthorSearchCriteria("A1"),
                new TitleSearchCriteria("T1"));

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        assertTrue(orSearchCriteria.match(bookDatabase.books.get(0)));

    }

    @Test
    public void andSearchCriteriaTest() {

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();
        AndSearchCriteria andSearchCriteria = new AndSearchCriteria(
                new AuthorSearchCriteria("A1"),
                new TitleSearchCriteria("T1"));

        bookDatabase.save(new Book("A1", "T1"));
        bookDatabase.save(new Book("A2", "T2"));
        bookDatabase.save(new Book("A3", "T3"));
        bookDatabase.save(new Book("A4", "T4"));

        assertTrue(andSearchCriteria.match(bookDatabase.books.get(0)));

    }
}