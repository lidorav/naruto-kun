package algorithms.search;

import java.util.ArrayList;

/**
 * Interface describing the methods for a searchable problem must apply.
 */
public interface ISearchable {

    /**
     * this is the state from which you start solving the problem.
     * @return the Start state of the problem.
     */
    AState getStartState();

    /**
     * this is the state you need to find to solve the problem (finished)
     * @return the goal state of the problem
     */
    AState getGoalState();

    /**
     * Get all the adjacent states for a given state, you can progress to any of the adjacent states in a cost x
     * @param as  the current state you are in the domain.
     * @return a list of adjacent (neighbors) states.
     */
    ArrayList <AState> getAllPossibleStates(AState as);
}
