package servis.UserInterface.SaveBookUI;

import bean.Book;
import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static application.BookLibraryApplication.getConnection;

public class SaveBookUIAction implements UIAction {

    private BookDatabase bookDatabase;
//    private Statement statement;

    public SaveBookUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        String authorBook;
        String titleBook;
        String yearOfIssueBook;

        Scanner scanner = new Scanner(System.in);

        System.out.println("__________________________________________________________________________________");
        System.out.println("Сохранение книги! ");

        System.out.println("__________________________________________________________________________________");
        System.out.println("Введите Имя автора книги: ");

        authorBook = scanner.nextLine();

        System.out.println("__________________________________________________________________________________");
        System.out.println("Введите название книги: ");

        titleBook = scanner.nextLine();

        System.out.println("__________________________________________________________________________________");
        System.out.println("Введите год выпуска книги: ");

        yearOfIssueBook = scanner.nextLine();
//ДОРАБОТАТЬ!!!!
        if (titleBook != "" || authorBook != "" || yearOfIssueBook != ""){

            bookDatabase.save(new Book(authorBook, titleBook, yearOfIssueBook));

            try {

                Statement statement = getConnection().createStatement();

                statement.executeUpdate("INSERT Books(AuthorBook, TittleBook, YearOfIssueBook)"
                                + " VALUES " +
                                "(" + "'" + authorBook + "', "
                                + "'" + titleBook + "', "
                                + "'" +  yearOfIssueBook +"'" +")");

            } catch (SQLException | IOException throwables) {

                throwables.printStackTrace();

            }

            System.out.println("__________________________________________________________________________________");
            System.out.println("Книга сохранена!" + "\n" + bookDatabase.findByAuthor(authorBook));
            System.out.println("__________________________________________________________________________________");

        } else {

            System.out.println("__________________________________________________________________________________");
            System.out.println("Вы забыли что-то добавить!" + "\n" + "Попробуйте сново!");
            System.out.println("__________________________________________________________________________________");

            execute();

        }
    }

    @Override
    public String toString() {
        return "SaveBookUIAction";
    }

}
