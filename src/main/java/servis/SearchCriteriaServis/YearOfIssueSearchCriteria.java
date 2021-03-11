package servis.SearchCriteriaServis;

import bean.Book;

public class YearOfIssueSearchCriteria implements SearchCriteria {

    private final String yearOfIssueToSearch;

    public YearOfIssueSearchCriteria(String yearOfIssueToSearch) {

        this.yearOfIssueToSearch = yearOfIssueToSearch;

    }

    @Override
    public boolean match(Book book) {

        return book.getYearOfIssue().equals(this.yearOfIssueToSearch);

    }
}
