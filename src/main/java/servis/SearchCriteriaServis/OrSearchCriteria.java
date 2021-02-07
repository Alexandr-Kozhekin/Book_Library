package servis.SearchCriteriaServis;

import bean.Book;

public class OrSearchCriteria implements SearchCriteria {

    private SearchCriteria leftCondition;
    private SearchCriteria rightCondition;

    public OrSearchCriteria(SearchCriteria leftCondition,
                            SearchCriteria rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }

    @Override
    public boolean match(Book book) {

        if (leftCondition.match(book) || rightCondition.match(book)) {

            return true;

        } else {

            return false;

        }

    }
}
