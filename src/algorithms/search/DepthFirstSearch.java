package algorithms.search;
import java.util.ArrayList;
import java.util.Stack;
public class DepthFirstSearch extends ASearchingAlgorithm {
    private Stack<AState> stack;

    public DepthFirstSearch() {
        super();
        stack = new Stack<>();

    }

    @Override
    public Solution solve(ISearchable domain) {
        AState startState = domain.getStartState();
        AState goalState = domain.getGoalState();
        stack.add(startState);
        startState.setVisited(true);
        while (!stack.isEmpty()) {
            AState current = stack.pop();
            ArrayList<AState> neighbours = domain.getAllPossibleStates(current);
            super.expandable++;
            for (int i = 0; i < neighbours.size(); i++) {
                AState temp = neighbours.get(i);
                if (!temp.isVisited()) {
                    stack.add(temp);
                    temp.setVisited(true);
                    if (temp.equals(goalState)) {
                        domain.getGoalState().setCameFrom(temp.getCameFrom());
                        return new Solution(temp);
                    }
                }
            }
        }
    return null;
    }
}
