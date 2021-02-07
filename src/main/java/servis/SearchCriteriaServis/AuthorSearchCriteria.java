package servis.SearchCriteriaServis;

import bean.Book;

public class AuthorSearchCriteria implements SearchCriteria {

    private String authorToSearch;

    public AuthorSearchCriteria(String authorToSearch) {

        this.authorToSearch = authorToSearch;

    }

    @Override
    public boolean match(Book book) {

        if(book.getAuthor().equals(this.authorToSearch)){

            return true;

        } else {

            return false;

        }

    }
}
