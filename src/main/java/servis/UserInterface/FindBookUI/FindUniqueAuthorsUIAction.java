package servis.UserInterface.FindBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

public class FindUniqueAuthorsUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public FindUniqueAuthorsUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        System.out.println("__________________________________________________________________________________");
        System.out.println("Поиск уникальных Авторов книг!" + "\n");
        System.out.println("Список Авторов: " + bookDatabase.findUniqueAuthors());
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "FindUniqueAuthorsUIAction";
    }

}
