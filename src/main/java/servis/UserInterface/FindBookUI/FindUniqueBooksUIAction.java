package servis.UserInterface.FindBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

public class FindUniqueBooksUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public FindUniqueBooksUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        System.out.println("__________________________________________________________________________________");
        System.out.println("Получение уникальных книг!" + "\n");
        System.out.println("Список уникальных книг: " + bookDatabase.findUniqueBooks());
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "FindUniqueBooksUIAction";
    }

}
