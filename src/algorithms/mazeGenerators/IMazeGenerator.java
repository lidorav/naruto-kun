package algorithms.mazeGenerators;

/**
 * Interface that holds all the methods to create a Maze
 */
public interface IMazeGenerator {
    /**
     * Creates a maze from a giving row and column
     * @param row the width of the maze
     * @param col the height of the maze
     * @return a Maze
     */
    Maze generate (int row, int col);

    /**
     *calculate time between start and end of the maze generation
     * @param row - number of rows in maze
     * @param col -  number of rows in maze
     * @return time of maze generate
     */
    long measureAlgorithmTimeMillis (int row, int col);
}
