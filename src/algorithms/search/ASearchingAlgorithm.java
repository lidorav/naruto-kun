package algorithms.search;

import java.util.HashSet;

/**
 * Abstract class that represent searching algorithms, it contains a variable that count the number of states developed
 */
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int expandable;
    protected HashSet<AState> closed;


    /**
     * C'tor - define that count variable as 0
     */
    public ASearchingAlgorithm() {
        this.expandable = 0;
        closed = new HashSet<>();
    }

    /**
     * Find a solution to a problem by a given searchable domain
     * @param domain the searchable variable that need a solution
     * @return Solution to the problem
     */
    public abstract Solution solve(ISearchable domain);

    /**
     * @return the number of states developed until we found the solution
     */
    public int getNumberOfNodesEvaluated() {
        return expandable;
    }

    /**
     * @return the searching algorithm name used to find the solution
     */
    public String getName() {
        return getClass().getName();
    }
}

