package servis.SearchCriteriaServis;

import bean.Book;

public class OrSearchCriteria implements SearchCriteria {

    private final SearchCriteria leftCondition;
    private final SearchCriteria rightCondition;

    public OrSearchCriteria(SearchCriteria leftCondition,
                            SearchCriteria rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }

    @Override
    public boolean match(Book book) {

        return leftCondition.match(book) || rightCondition.match(book);

    }
}
