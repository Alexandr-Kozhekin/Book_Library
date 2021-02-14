package servis.UserInterface;

import servis.BookServis.BookDatabase;
import servis.BookServis.BookDatabaseImpl;
import servis.UserInterface.DeleteBookUI.DeleteBookByBookUIAction;
import servis.UserInterface.DeleteBookUI.DeleteByAuthorUIAction;
import servis.UserInterface.DeleteBookUI.DeleteByIdUIAction;
import servis.UserInterface.DeleteBookUI.DeleteByTitleUIAction;
import servis.UserInterface.FindBookUI.*;
import servis.UserInterface.GetBookUI.ContainsBookUIAction;
import servis.UserInterface.GetBookUI.CountAllBooksUIAction;
import servis.UserInterface.GetBookUI.GetAuthorToBooksMapUIAction;
import servis.UserInterface.GetBookUI.GetEachAuthorBookCountUIAction;
import servis.UserInterface.SaveBookUI.SaveBookUIAction;
import servis.UserInterface.SearchByCriteriaUI.SearchCriteriaUIAction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookLibrary {

    private Map<Integer, UIAction> menuNumberToActionMap;

    public BookLibrary() {

        BookDatabase bookDatabase = new BookDatabaseImpl();

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(1, new SaveBookUIAction(bookDatabase));
        menuNumberToActionMap.put(2, new SearchCriteriaUIAction(bookDatabase));
        menuNumberToActionMap.put(3, new FindByIdUIAction(bookDatabase));
        menuNumberToActionMap.put(4, new FindByAuthorUIAction(bookDatabase));
        menuNumberToActionMap.put(5, new FindByTitleUIAction(bookDatabase));
        menuNumberToActionMap.put(6, new FindByYearOfIssueUIAction(bookDatabase));
        menuNumberToActionMap.put(7, new FindUniqueAuthorsUIAction(bookDatabase));
        menuNumberToActionMap.put(8, new FindUniqueTitlesUIAction(bookDatabase));
        menuNumberToActionMap.put(9, new FindUniqueBooksUIAction(bookDatabase));
        menuNumberToActionMap.put(10, new ContainsBookUIAction(bookDatabase));
        menuNumberToActionMap.put(11, new CountAllBooksUIAction(bookDatabase));
        menuNumberToActionMap.put(12, new GetAuthorToBooksMapUIAction(bookDatabase));
        menuNumberToActionMap.put(13, new GetEachAuthorBookCountUIAction(bookDatabase));
        menuNumberToActionMap.put(14, new DeleteByIdUIAction(bookDatabase));
        menuNumberToActionMap.put(15, new DeleteByAuthorUIAction(bookDatabase));
        menuNumberToActionMap.put(16, new DeleteByTitleUIAction(bookDatabase));
        menuNumberToActionMap.put(17, new DeleteBookByBookUIAction(bookDatabase));

    }

    public void run() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Пожалуйста введите номер меню: ");

            for (int i = 1; i < menuNumberToActionMap.size() + 1; i++){

                System.out.println(i + " - " + menuNumberToActionMap.get(i).toString());

            }

            int userSelectedMenuNumber = Integer.parseInt(sc.nextLine());

            if (userSelectedMenuNumber == 0) {

                System.out.println("Спасибо! Досвидания!");

                break;

            } else {

                executeUIAction(userSelectedMenuNumber);

            }
        }
    }

    private void executeUIAction(int userSelectedMenuNumber) {

        UIAction uiAction = menuNumberToActionMap.get(userSelectedMenuNumber);

        if (uiAction != null) {

            uiAction.execute();

        } else {

            System.out.println("Такого пункта в меню нет: " + userSelectedMenuNumber);

        }
    }

}
