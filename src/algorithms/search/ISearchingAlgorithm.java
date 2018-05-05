package algorithms.search;

/**
 * Interface for all the methods searching algorithms must apply.
 */
public interface ISearchingAlgorithm {

    /**
     * solving the searchable problem in a given domain
     * @param domain the area which the problem occur
     * @return Solution to the problem
     */
    Solution solve (ISearchable domain);

    /**
     * @return the number of times we used "give all the possible states I can progress" for each state
     * until we solved the problem.
     */
    int getNumberOfNodesEvaluated();

    /**
     * @return the name of the algorithm we used to solve the problem.
     */
    String getName();
}

