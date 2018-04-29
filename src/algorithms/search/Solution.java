package algorithms.search;

import java.util.ArrayList;

public class Solution {
    ArrayList<AState> solutionPath;

    public Solution(AState goalState) {
        solutionPath = new ArrayList<>();
        AState temp = goalState;
        while(temp!=null){
            solutionPath.add(0,temp);
            temp=temp.getCameFrom();
        }
    }

    public ArrayList<AState> getSolutionPath(){
        return solutionPath;
    }
}