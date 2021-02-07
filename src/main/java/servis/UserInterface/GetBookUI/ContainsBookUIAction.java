package servis.UserInterface.GetBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

import java.util.Scanner;

public class ContainsBookUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public ContainsBookUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        String authorBook;
        String titleBook;

        try {

            System.out.println("__________________________________________________________________________________");
            System.out.println("Поиск книги!" + "\n\n" + "Для того что-бы узнать есть ли книга в " +
                    "списке введите полные данные книги!");

            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("__________________________________________________________________________________");
            System.out.println("Введите Имя автора книги: ");

            authorBook = scanner.nextLine();

            System.out.println("__________________________________________________________________________________");
            System.out.println("Введите название книги: ");

            titleBook = scanner.nextLine();

            if (titleBook != "" || authorBook != "") {
//Спорный момент реализации
                System.out.println("__________________________________________________________________________________");
                System.out.println("Книга найдена!" + bookDatabase.contains(bookDatabase.findByTitle(titleBook).get(0)));
                System.out.println("__________________________________________________________________________________");

            } else {

                System.out.println("__________________________________________________________________________________");
                System.out.println("Вы забыли что-то добавить!" + "\n" + "Попробуйте сново!");
                System.out.println("__________________________________________________________________________________");

                execute();

            }
        } catch (Exception e) {

            System.out.println("__________________________________________________________________________________");
            System.out.println("Такой книги в списке нет!");
            System.out.println("__________________________________________________________________________________");

        }
    }

    @Override
    public String toString() {
        return "ContainsBookUIAction";
    }

}
