package algorithms.search;

import java.util.ArrayList;

/**
 * A class that represent the solution for a searchable problem.
 */
public class Solution {
    ArrayList<AState> solutionPath;

    /**
     * C'tor - creates a list that contains a path or instructions to solve the problem from the starting state until the goal state.
     * @param goalState the finishing state of the problem - goal state
     */
    public Solution(AState goalState) {
        solutionPath = new ArrayList<>();
        AState temp = goalState;
        while(temp!=null){
            solutionPath.add(0,temp);
            temp=temp.getCameFrom();
        }
    }

    /**
     * @return a list of instructions to solve the problem
     */
    public ArrayList<AState> getSolutionPath(){
        return solutionPath;
    }
}