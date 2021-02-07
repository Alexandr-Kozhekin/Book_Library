package servis.UserInterface.DeleteBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteByIdUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public DeleteByIdUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        Long bookID;
        String choice;
        String makeChoiceYes = "Y";
        String makeChoiceNot = "N";

        System.out.println("__________________________________________________________________________________");
        System.out.println("Удаление книги по ID!");
        System.out.println("__________________________________________________________________________________");

        try {

            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("Введите ID книги: ");

            bookID = scanner.nextLong();

            System.out.println("__________________________________________________________________________________");
            System.out.println("Вы уверенны что хотите удалить эту книгу?" + "\n\n" + "              Y/N");

            choice = scanner1.nextLine();

            if (choice.equalsIgnoreCase(makeChoiceYes)) {

                boolean deleteBook = bookDatabase.deleteBook(bookID);

                if (deleteBook == true) {

                    System.out.println("__________________________________________________________________________________");
                    System.out.println("Книга удалена!");
                    System.out.println("__________________________________________________________________________________");

                } else {

                    System.out.println("__________________________________________________________________________________");
                    System.out.println("Книга не найдена!");
                    System.out.println("__________________________________________________________________________________");

                }

            } else if (choice.equalsIgnoreCase(makeChoiceNot)) {

                System.out.println("Отмена!");
                System.out.println("__________________________________________________________________________________");


            } else {

                System.out.println("Принято как отмена!");
                System.out.println("__________________________________________________________________________________");

            }

        } catch (InputMismatchException e){

            System.out.println("__________________________________________________________________________________");
            System.out.println("Пожалуйста, введите целое число! ");

            execute();
        }
    }

    @Override
    public String toString() {
        return "DeleteByIdUIAction";
    }
}
