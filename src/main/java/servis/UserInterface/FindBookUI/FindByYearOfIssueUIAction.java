package servis.UserInterface.FindBookUI;

import servis.BookServis.BookDatabase;
import servis.UserInterface.UIAction;

import java.util.Scanner;

public class FindByYearOfIssueUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public FindByYearOfIssueUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        String yearOfIssue;

        Scanner scanner = new Scanner(System.in);
        System.out.println("__________________________________________________________________________________");
        System.out.println("Поиск книги по дате выпуска!");
        System.out.println("__________________________________________________________________________________");

        System.out.println("Для поиска книги введите Дату выпуска книги:");

        yearOfIssue = scanner.nextLine();

        System.out.println("__________________________________________________________________________________");
        System.out.println("Список найденыйх киг: " + "\n" + bookDatabase.findByYears(yearOfIssue));
        System.out.println("__________________________________________________________________________________");

    }

    @Override
    public String toString() {
        return "FindByYearOfIssueUIAction";
    }
}
