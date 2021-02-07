package servis.UserInterface.GetBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

public class CountAllBooksUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public CountAllBooksUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        System.out.println("__________________________________________________________________________________");
        System.out.println("Колличество книг в списке!" + "\n");
        System.out.println("Колличество книг: " + bookDatabase.countAllBooks());
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "CountAllBooksUIAction";
    }

}
