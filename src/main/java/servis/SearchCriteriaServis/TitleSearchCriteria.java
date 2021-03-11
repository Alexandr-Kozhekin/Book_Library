package servis.SearchCriteriaServis;

import bean.Book;

public class TitleSearchCriteria implements SearchCriteria {

    private final String titleToSearch;

    public TitleSearchCriteria(String titleToSearch) {

        this.titleToSearch = titleToSearch;

    }

    @Override
    public boolean match(Book book) {

        return book.getTitle().equals(this.titleToSearch);

    }
}
