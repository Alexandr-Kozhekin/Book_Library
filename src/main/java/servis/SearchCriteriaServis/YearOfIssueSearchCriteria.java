package servis.SearchCriteriaServis;

import bean.Book;

public class YearOfIssueSearchCriteria implements SearchCriteria {

    private String yearOfIssueToSearch;

    public YearOfIssueSearchCriteria(String yearOfIssueToSearch) {

        this.yearOfIssueToSearch = yearOfIssueToSearch;

    }

    @Override
    public boolean match(Book book) {

        if(book.getYearOfIssue().equals(this.yearOfIssueToSearch)){

            return true;

        } else {

            return false;

        }

    }
}
