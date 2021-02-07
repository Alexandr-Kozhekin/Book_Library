package servis.UserInterface.GetBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

public class GetEachAuthorBookCountUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public GetEachAuthorBookCountUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        System.out.println("__________________________________________________________________________________");
        System.out.println("Получение уникальных авторов и количества написанных ими книг!" + "\n");
        System.out.println("Список уникальных авторов: " + bookDatabase.getEachAuthorBookCount());
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "GetEachAuthorBookCountUIAction";
    }

}
