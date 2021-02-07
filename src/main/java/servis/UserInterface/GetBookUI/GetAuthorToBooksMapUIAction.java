package servis.UserInterface.GetBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

public class GetAuthorToBooksMapUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public GetAuthorToBooksMapUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        System.out.println("__________________________________________________________________________________");
        System.out.println("Получение уникальных авторов и списка написанных ими книг!" + "\n");
        System.out.println("Список уникальных авторов: " + bookDatabase.getAuthorToBooksMap());
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "GetAuthorToBooksMapUIAction";
    }

}
