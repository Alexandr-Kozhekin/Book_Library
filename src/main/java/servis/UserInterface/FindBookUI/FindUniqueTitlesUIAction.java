package servis.UserInterface.FindBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

public class FindUniqueTitlesUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public FindUniqueTitlesUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        System.out.println("__________________________________________________________________________________");
        System.out.println("Поиск уникальных тайтлов!" + "\n");
        System.out.println("Список тайтлов: " + bookDatabase.findUniqueTitles());
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "FindUniqueTitlesUIAction";
    }

}
