package bean;

import java.util.Objects;

public class Book {

    private Long id;
    private String title;
    private String author;
    private String yearOfIssue;

    public Book(String author, String title) {

        this.author = author;
        this.title = title;

    }

    public Book(String author, String title, String yearOfIssue) {

        this.author = author;
        this.title = title;
        this.yearOfIssue = yearOfIssue;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public Long getId() {

        return this.id;

    }

    public String getTitle() {

        return this.title;

    }

    public String getAuthor() {

        return this.author;

    }

    public String getYearOfIssue() {

        return yearOfIssue;

    }

    public void setYearOfIssue(String yearOfIssue) {

        this.yearOfIssue = yearOfIssue;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfIssue='" + yearOfIssue + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void reName(Book [] book, String [] title) {

        book[0].setTitle("we");

    }
}