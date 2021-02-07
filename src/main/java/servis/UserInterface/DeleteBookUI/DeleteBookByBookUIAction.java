package servis.UserInterface.DeleteBookUI;

import bean.Book;
import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

import java.io.IOException;
import java.util.Scanner;

public class DeleteBookByBookUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public DeleteBookByBookUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        String authorBook;
        String titleBook;
        String choice;
        String makeChoiceYes = "Y";
        String makeChoiceNot = "N";

        try {

            System.out.println("__________________________________________________________________________________");
            System.out.println("Удаление книги!" + "\n\n" + "Для удаления книги введите полные данные книги!");

            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("__________________________________________________________________________________");
            System.out.println("Введите Имя автора книги: ");

            authorBook = scanner.nextLine();

            System.out.println("__________________________________________________________________________________");
            System.out.println("Введите название книги: ");

            titleBook = scanner.nextLine();

            System.out.println("__________________________________________________________________________________");
            System.out.println("Вы уверенны что хотите удалить эту книгу?" + "\n\n" + "              Y/N");

            choice = scanner1.nextLine();

            if (choice.equalsIgnoreCase(makeChoiceYes)) {
//Возмодно спорный момент реализации
                boolean deleteBook = bookDatabase.deleteBook(bookDatabase.findByAuthor(authorBook).get(0));

                if (deleteBook == true && titleBook != "" || authorBook != "") {

                    System.out.println("__________________________________________________________________________________");
                    System.out.println("Книга удалена!" + deleteBook);
                    System.out.println("__________________________________________________________________________________");

                } else {

                    System.out.println("__________________________________________________________________________________");
                    System.out.println("Вы забыли что-то добавить!" + "\n" + "Попробуйте сново!");
                    System.out.println("__________________________________________________________________________________");

                    execute();

                }

            } else if (choice.equalsIgnoreCase(makeChoiceNot)){

                System.out.println("Отмена!");
                System.out.println("__________________________________________________________________________________");

            } else {

                System.out.println("Принято как отмена!");
                System.out.println("__________________________________________________________________________________");

            }

        } catch (Exception e) {

            System.out.println("__________________________________________________________________________________");
            System.out.println("Такой книги нет!");
            System.out.println("__________________________________________________________________________________");

        }

    }

    @Override
    public String toString() {
        return "DeleteBookByBookUIAction";
    }
}
