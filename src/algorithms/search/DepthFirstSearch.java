package algorithms.search;
import java.util.ArrayList;
import java.util.Stack;
public class DepthFirstSearch extends ASearchingAlgorithm {
    private Stack<AState> openStack;

    public DepthFirstSearch() {
        openStack = new Stack<>();
    }

    @Override
    public Solution solve(ISearchable domain) {
        AState startState = domain.getStartState();
        AState goalState = domain.getGoalState();
        openStack.add(startState);
        closed.add((startState));
        while (!openStack.isEmpty()) {
            AState current = openStack.pop();
            ArrayList<AState> neighbours = domain.getAllPossibleStates(current);
            expandable++;
            for (AState neighbor : neighbours) {
                if(closed.contains(neighbor))
                    continue;
                // checks for exit
                if (neighbor.equals(goalState)) {
                    goalState.setCameFrom(neighbor.getCameFrom());
                    return new Solution(goalState);
                }
                // we know every neighbor in neighbors is unvisited
                openStack.add(neighbor);
                // marks neighbor as visited in array
                closed.add(neighbor);

                }
            }
    return null;
    }
}
