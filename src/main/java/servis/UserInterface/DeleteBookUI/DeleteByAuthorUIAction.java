package servis.UserInterface.DeleteBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

import java.util.Scanner;

public class DeleteByAuthorUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public DeleteByAuthorUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        String deleteAuthor;
        String choice;
        String makeChoiceYes = "Y";
        String makeChoiceNot = "N";

        try {

            System.out.println("__________________________________________________________________________________");
            System.out.println("Удаление книги по Имени авторв!" + "\n\n" + "Для удаления книги введите Имя автора!");

            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("__________________________________________________________________________________");
            System.out.println("Введите Имя автора книги: ");

            deleteAuthor = scanner.nextLine();

            System.out.println("__________________________________________________________________________________");
            System.out.println("Вы уверенны что хотите удалить эту книгу?" + "\n\n" + "              Y/N");

            choice = scanner1.nextLine();

            if (choice.equalsIgnoreCase(makeChoiceYes)) {

                if (deleteAuthor != "") {

                    System.out.println("__________________________________________________________________________________");
                    System.out.println("Книга удалена!" + "\n");

                    bookDatabase.deleteByAuthor(deleteAuthor);

                    System.out.println("__________________________________________________________________________________");

                } else {

                    System.out.println("Введите Имя автора!" + "\n" + "Попробуйте сново!");
                    System.out.println("__________________________________________________________________________________");

                    execute();

                }

            } else if (choice.equalsIgnoreCase(makeChoiceNot)) {

                System.out.println("Отмена!");
                System.out.println("__________________________________________________________________________________");

            } else {

                System.out.println("Принято как отмена!");
                System.out.println("__________________________________________________________________________________");

            }

        } catch(Exception e){

            System.out.println("__________________________________________________________________________________");
            System.out.println("Такой книги нет!");
            System.out.println("__________________________________________________________________________________");

        }
    }

    @Override
    public String toString() {
        return "DeleteByAuthorUIAction";
    }
}

