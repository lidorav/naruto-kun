package algorithms.mazeGenerators;

/**
 * A class that builds a maze with a simple algortihm.
 * After creating the 2D array you randomly choose the start and end point.
 * create a simple path between them, and randomly choose 1 or 0 for all the walls that left (without the edges)
 */
public class SimpleMazeGenerator extends AMazeGenerator {
    int[][] temp2DArr;
    int row;
    int col;
    Position startPos;
    Position goalPos;

    /**
     * the main function that generate the maze
     * @param row the maze width
     * @param col the maze height
     * @return a Maze
     */
    @Override
    public Maze generate(int row, int col) {
        if(row < 4 || col < 4){
            System.out.println("Maze measurments cannot be under 4");
            row=10;
            col=10;
        }
        this.row = row;
        this.col = col;
        temp2DArr = new int[row][col];
        initArr();
        startPos = createStartPosition();
        goalPos = createGoalPosition();
        makePath();
        randomizeWalls();
        return new Maze(temp2DArr, startPos, goalPos);
    }

    /**
     * Initialize all maze to walls
     */
    private void initArr() {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                temp2DArr[i][j] = 1;
    }

    /**
     * Choose randomly a starting point at one of the edges of the maze.
     * @return position that represent the start point to the maze
     */
    private Position createStartPosition() {
        int i, j, applyValue;
        applyValue = (int) (Math.random() * 2); // choose what value to apply the const var between 2 options
        if (applyValue == 0)
            i = 0;
        else
            i = row - 1;
        j = 1 + (int) (Math.random() * (col - 2));
        temp2DArr[i][j] = 0;
        return new Position(i, j);
    }

    /**
     * Choose randomly a goal point at one of the edges of the maze.
     * @return position that represent the goal point to the maze
     */
    private Position createGoalPosition() {
        int i = 0, j = 0;
        if (startPos.getRowIndex() == 0) {
            i = row - 1;
            j = 1 + (int) (Math.random() * (col - 2));
        }
        if (startPos.getRowIndex() == row - 1) {
            i = 0;
            j = 1 + (int) (Math.random() * (col - 2));
        }
        temp2DArr[i][j] = 0;
        return new Position(i, j);
    }


    /**
     * Creates a path from the starting position to the goal position in the 2D array (0 = path)
     */
    private void makePath() {
        int i, j;
        if (startPos.getRowIndex() == 0) {
            for (i = startPos.getRowIndex() + 1; i < row - 2; i++)
                temp2DArr[i][startPos.getColumnIndex()] = 0;
            if ((startPos.getColumnIndex() >= goalPos.getColumnIndex()))
                for (j = startPos.getColumnIndex(); j >= goalPos.getColumnIndex(); j--)
                    temp2DArr[goalPos.getRowIndex() - 1][j] = 0;
            else for (j = startPos.getColumnIndex(); j <= goalPos.getColumnIndex(); j++)
                temp2DArr[goalPos.getRowIndex() - 1][j] = 0;
        }
        if (startPos.getRowIndex() == row - 1) {
            for (i = startPos.getRowIndex() - 1; i > 0; i--)
                temp2DArr[i][startPos.getColumnIndex()] = 0;
            if ((startPos.getColumnIndex() >= goalPos.getColumnIndex()))
                for (j = startPos.getColumnIndex(); j >= goalPos.getColumnIndex(); j--)
                    temp2DArr[goalPos.getRowIndex() + 1][j] = 0;
            else for (j = startPos.getColumnIndex(); j <= goalPos.getColumnIndex(); j++)
                temp2DArr[goalPos.getRowIndex() + 1][j] = 0;
        }
    }

    /**
     * All the walls (1) that inside the maze not including the outer walls (edges) are being randomize for a wall (1) or a path (0)
     */
    private void randomizeWalls() {
        for (int i = 1; i < row - 1; i++)
            for (int j = 1; j < col - 1; j++)
                if (temp2DArr[i][j] == 1)
                    temp2DArr[i][j] = (int) (Math.random() * 2);
    }
}