package servis.SearchCriteriaServis;

import bean.Book;

public interface SearchCriteria {

    boolean match(Book book);

}
