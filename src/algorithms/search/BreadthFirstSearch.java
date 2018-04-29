package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that represent a BFS (Breadth First Search) searching algorithm for a searchable domain
 */
public class BreadthFirstSearch extends ASearchingAlgorithm {

    private Queue<AState> Q;

    /**
     * C'tor - Creates a BFS cont
     */
    public BreadthFirstSearch() {
        super();
        // declares new queue
        Q = new LinkedList<>();
    }

    @Override
    public Solution solve(ISearchable domain) {
        AState startState = domain.getStartState();
        AState goalState = domain.getGoalState();
        // pushes source to Q
        Q.add(startState);
        // enters main loop - checks if Q is nonempty
        while (Q.peek() != null) {
            // gets next element off of queue
            AState current = Q.poll();
            // gets neighbors of current
            ArrayList<AState> neighbors = domain.getAllPossibleStates(current);
            super.expandable++;
            // iterates through set of all neighbors (nice java syntax)
            for (AState neighbor : neighbors) {
                // checks for exit
                if (neighbor.equals(goalState)) {
                    goalState.setCameFrom(neighbor.getCameFrom());
                    return new Solution(goalState);
                }
                // we know every neighbor in neighbors is unvisited - why?

                Q.add(neighbor);
                // marks neighbor as visited in array
                neighbor.setVisited(true);
            }
        }
        return null;
    }
}
