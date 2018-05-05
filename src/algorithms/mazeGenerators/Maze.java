package algorithms.mazeGenerators;

/**
 * A class that represent a Maze, it contains 2D integer array, the position starting point and goal point.
 */
public class Maze {
    private int [][] m_2DArr;
    private Position startPosition;
    private Position goalPosition;

    /**
     * C'tor - Creates a maze by a given array, start position and end position
     * @param m_2DArr - 2D int array (0,1)
     * @param startPosition - the entrance coordinates to the maze
     * @param goalPosition - the exit coordinates from the maze
     */
    public Maze(int[][] m_2DArr, Position startPosition, Position goalPosition) {
        this.m_2DArr = m_2DArr;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
    }

    /**
     * @return the maze array
     */
    public int[][] getM_2DArr() {
        return m_2DArr;
    }

    /**
     * @return the position of the maze starting point
     */
    public Position getStartPosition() {
        return startPosition;
    }

    /**
     * @return the position of the maze exit point
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     * Print the maze array, while exchanging the start Position with 'S' and the goal Position with 'E'
     */
    public void print() {
        int i=0,j=0;
        for (i = 0; i < m_2DArr.length; i++) {
            System.out.print("[ ");
            for (j = 0; j < m_2DArr[i].length; j++) {
                if (i == startPosition.getRowIndex() && j == startPosition.getColumnIndex()) {
                    System.out.print("S ");
                    continue;
                }
                if (i == goalPosition.getRowIndex() && j == goalPosition.getColumnIndex()) {
                    System.out.print("E ");
                    continue;
                }
                System.out.print(m_2DArr[i][j] + " ");
            }
            System.out.print("] \n");
        }
    }
}


