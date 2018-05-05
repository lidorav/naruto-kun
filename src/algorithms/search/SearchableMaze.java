package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import java.util.ArrayList;

/**
 * A class that represent a searchable maze, it contains the maze itself, the start start and the goal state.
 */
public class SearchableMaze implements ISearchable {
    private Maze maze;
    private MazeState startState;
    private MazeState endState;

    /**
     * C'tor - Create a searchable maze by defining the start state and the goal state
     * @param maze is the maze we are searching on
     */
    public SearchableMaze(Maze maze) {
        this.maze = maze;
        startState = new MazeState(maze.getStartPosition(),0,null);
        endState = new MazeState(maze.getGoalPosition(),1,null);
    }

    /**
     * Return the start state of the maze
     * @return start state
     */
    @Override
    public AState getStartState() {
        return startState;
    }

    /**
     * Return the goal state of the maze
     * @return goal state
     */
    @Override
    public AState getGoalState() {
        return endState;
    }

    /**
     * Bring all possible neighbors states from the given maze state
     * @param as current state on the maze
     * @return list of all neighbors maze states
     */
    @Override
    public ArrayList<AState> getAllPossibleStates(AState as) {
        MazeState ms = (MazeState) as;
        ArrayList<AState> states = new ArrayList<>();
        Position current = ms.getPos();

        //check all 8 directions
        for (int xOffset= -1; xOffset <= 1; xOffset++) {
            for (int yOffSet = -1; yOffSet <= 1; yOffSet++) {
                int neighborX = current.getRowIndex() + xOffset;
                int neighborY = current.getColumnIndex() + yOffSet;
                //check if the neighbor is in valid place
                if (checkValidNeighbor(neighborX, neighborY)) {
                    //choose only the diagonal neighbors
                    if ((xOffset == 1 || xOffset == -1) && (yOffSet == 1 || yOffSet == -1)) {
                        //check if the diagonal neighbor has a valid path
                        if (checkDiagonalPath(xOffset, yOffSet, current)) {
                            //add the diagonal neighbor to the neighbors list
                            states.add(new MazeState(new Position(neighborX, neighborY), 1.5, ms));
                            //mark the neighbor as visited
                        } else
                            continue;
                    }
                    else{
                        //add the neighbor the the neighbors list
                        states.add(new MazeState(new Position(neighborX, neighborY), 1, ms));
                    }
                }
            }
        }
        return states;
    }

    /**
     * Check if there is a valid path from the current position on the map to the diagonal coordinates.
     * @param xOffset the offset from the current x coordinates
     * @param yOffset the offset from the current y coordinates
     * @param current the current position in the maze
     * @return true if there is a path, false otherwise.
     */
    private boolean checkDiagonalPath(int xOffset, int yOffset, Position current) {
        int currentX = current.getRowIndex();
        int currentY = current.getColumnIndex();
        switch(xOffset*2+yOffset){

            case -1:
                return (maze.getM_2DArr()[currentX-1][currentY]==0 ||
                        maze.getM_2DArr()[currentX][currentY+1]==0);
            case -3:
                return (maze.getM_2DArr()[currentX-1][currentY]==0 ||
                        maze.getM_2DArr()[currentX][currentY-1]==0);
            case 1:
                return (maze.getM_2DArr()[currentX+1][currentY]==0 ||
                        maze.getM_2DArr()[currentX][currentY-1]==0);
            case 3:
                return (maze.getM_2DArr()[currentX+1][currentY]==0 ||
                        maze.getM_2DArr()[currentX][currentY+1]==0);
        }
        return false;
    }

    /**
     * Check if the given coordinates are inside the maze borders and it is a valid path.
     * Also it checks if we already visited that neighbor
     * @param xCord the row number on the maze
     * @param yCord the column number on the maze
     * @return true if its on the maze borders, its a valid path and we didn't visit it yet, false otherwise.
     */
    private boolean checkValidNeighbor(int xCord, int yCord){
        if (xCord > 0 && xCord < maze.getM_2DArr().length -1 && yCord > 0 && yCord < maze.getM_2DArr()[0].length)
            if(maze.getM_2DArr()[xCord][yCord]!= 1)
                    return true;
        return false;
    }
}
