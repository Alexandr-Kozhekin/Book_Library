package servis.UserInterface.FindBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

import java.util.Scanner;

public class FindByTitleUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public FindByTitleUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }


    @Override
    public void execute() {

        String titleBook;

        Scanner scanner = new Scanner(System.in);
        System.out.println("__________________________________________________________________________________");
        System.out.println("Поиск книги по названию!");
        System.out.println("__________________________________________________________________________________");

        System.out.println("Для поиска книги введите название книги:");

        titleBook = scanner.nextLine();

        System.out.println("__________________________________________________________________________________");
        System.out.println("Список найденыйх киг: " + "\n" + bookDatabase.findByTitle(titleBook));
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "FindByTitleUIAction";
    }
}
