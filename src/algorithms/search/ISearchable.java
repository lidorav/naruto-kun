package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {

    public MazeState getStartState();
    public MazeState getGoalState();
        public ArrayList <MazeState> getAllPossibleStates(AState s);
}
