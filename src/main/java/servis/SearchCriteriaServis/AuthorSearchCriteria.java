package servis.SearchCriteriaServis;

import bean.Book;

public class AuthorSearchCriteria implements SearchCriteria {

    private final String authorToSearch;

    public AuthorSearchCriteria(String authorToSearch) {

        this.authorToSearch = authorToSearch;

    }

    @Override
    public boolean match(Book book) {

        return book.getAuthor().equals(this.authorToSearch);

    }
}
