package algorithms.mazeGenerators;

/**
 * Abstract class for maze generator
 */
public abstract class AMazeGenerator implements IMazeGenerator {
    /**
     *Abstract function to generate a maze
     */
    public abstract Maze generate(int row, int col);

    /**
     *calculate time between start and end of the maze generation
     * @param row - number of rows in maze
     * @param col -  number of rows in maze
     * @return time of maze generate
     */
    @Override
    public long measureAlgorithmTimeMillis(int row, int col) {
        long startTime = System.currentTimeMillis();
        generate(row,col);
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
}
