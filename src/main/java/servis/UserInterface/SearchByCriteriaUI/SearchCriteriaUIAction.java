package servis.UserInterface.SearchByCriteriaUI;

import servis.BookServis.BookDatabase;
import servis.SearchCriteriaServis.*;
import servis.UserInterface.UIAction;

import java.util.*;

public class SearchCriteriaUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public SearchCriteriaUIAction(BookDatabase bookDatabase) {

        this.bookDatabase = bookDatabase;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("__________________________________________________________________________________");
        System.out.println("Поиск книг по выбранным критериям!");
        System.out.println("__________________________________________________________________________________");
        System.out.println("Выберите критерию поиска книги: " +
                "\n" + "1. ИМЯ АВТОРА" +
                "\n" + "2. НАЗВАНИЕ КНИГИ" +
                "\n" + "3. ГОД ВЫПУСКА КНИГИ" +
                "\n" + "4. ИМЯ АВТОРА и НАЗВАНИЕ КНИГИ" +
                "\n" + "5. ИМЯ АВТОРА и НАЗВАНИЕ КНИГИ");

        switch (scanner.nextInt()) {

            case 1 -> {
                System.out.println("Критерия поиска - ИМЯ АВТОРА" + "\n" + "Введите Имя автора: ");
                System.out.println(bookDatabase.find(new AuthorSearchCriteria(new Scanner(System.in).nextLine())));
                System.out.println("__________________________________________________________________________________");
            }

            case 2 -> {
                System.out.println("Критерия поиска - НАЗВАНИЕ КНИГИ" + "\n" + "Введите название книги: ");
                System.out.println(bookDatabase.find(new TitleSearchCriteria(new Scanner(System.in).nextLine())));
                System.out.println("__________________________________________________________________________________");
            }

            case 3 -> {
                System.out.println("Критерия поиска - ГОД ВЫПУСКА КНИГИ" + "\n" + "Введите год выпуска книги: ");
                System.out.println(bookDatabase.find(new YearOfIssueSearchCriteria(new Scanner(System.in).nextLine())));
                System.out.println("__________________________________________________________________________________");
            }

            case 4 -> {
                System.out.println("Критерии поиска - ИМЯ АВТОРА и НАЗВАНИЕ КНИГИ" + "\n" + "Введите Имя автора и название книги: ");
                System.out.println(bookDatabase.find(new AndSearchCriteria(new AuthorSearchCriteria(new Scanner(System.in).nextLine()),
                        new TitleSearchCriteria(new Scanner(System.in).nextLine()))));
                System.out.println("__________________________________________________________________________________");
            }

            case 5 -> {
                System.out.println("Критерии поиска - ИМЯ АВТОРА и НАЗВАНИЕ КНИГИ" + "\n" + "Введите Имя автора и название книги: ");
                System.out.println(bookDatabase.find(new OrSearchCriteria(new AuthorSearchCriteria(new Scanner(System.in).nextLine()),
                        new TitleSearchCriteria(new Scanner(System.in).nextLine()))));
                System.out.println("__________________________________________________________________________________");
            }

            default -> {
                System.out.println("Такой критерии нет!");
                System.out.println("__________________________________________________________________________________");
            }
        }
    }

    @Override
    public String toString() {
        return "SearchCriteriaUIAction";
    }
}
