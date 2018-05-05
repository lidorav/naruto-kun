package algorithms.search;

import java.util.*;

/**
 * A class that represent a BFS (Breadth First Search) searching algorithm for a searchable domain
 */
public class BreadthFirstSearch extends ASearchingAlgorithm {

    protected Queue<AState> openQ;

    /**
     * C'tor - Creates a BFS cont
     */
    public BreadthFirstSearch() {
        // declares new queue
        openQ = new LinkedList<>();
        //declares new hash-set
    }

    /**
     * Find a solution to a searchable domain with a BFS algorithm
     * @param domain the searchable variable that need a solution
     * @return Solution to the problem
     */
    @Override
    public Solution solve(ISearchable domain) {
        AState startState = domain.getStartState();
        AState goalState = domain.getGoalState();
        // pushes source to Q
        openQ.add(startState);
        closed.add(startState);
        // enters main loop - checks if Q is nonempty
        while (!openQ.isEmpty()) {
            // gets next element off of queue
            AState current = openQ.remove();
            // gets neighbors of current
            ArrayList<AState> neighbors = domain.getAllPossibleStates(current);
            expandable++;
            // iterates through set of all neighbors (nice java syntax)
            for (AState neighbor : neighbors) {
                if(closed.contains(neighbor))
                    continue;
                // checks for exit
                if (neighbor.equals(goalState)) {
                    goalState.setCameFrom(neighbor.getCameFrom());
                    return new Solution(goalState);
                }
                // we know every neighbor in neighbors is unvisited
                openQ.add(neighbor);
                // marks neighbor as visited in array
                closed.add(neighbor);
            }
        }
        return null;
    }
}
