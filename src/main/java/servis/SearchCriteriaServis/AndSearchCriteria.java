package servis.SearchCriteriaServis;

import bean.Book;

public class AndSearchCriteria implements SearchCriteria {

    private SearchCriteria leftCondition;
    private SearchCriteria rightCondition;

    public AndSearchCriteria(SearchCriteria leftCondition,
                             SearchCriteria rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }

    @Override
    public boolean match(Book book) {

        if(leftCondition.match(book) && rightCondition.match(book)){

            return true;

        } else {

            return false;

        }

    }
}
