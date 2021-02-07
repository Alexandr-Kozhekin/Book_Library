package servis.SearchCriteriaServis;

import bean.Book;

public class TitleSearchCriteria implements SearchCriteria {

    private String titleToSearch;

    public TitleSearchCriteria(String titleToSearch) {

        this.titleToSearch = titleToSearch;

    }

    @Override
    public boolean match(Book book) {

        if(book.getTitle().equals(this.titleToSearch)) {

            return true;

        } else {

            return false;

        }

    }
}
