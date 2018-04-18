package algorithms.mazeGenerators;


//nira
public class SimpleMazeGenerator extends AMazeGenerator {
    public SimpleMazeGenerator() {
    }

    @Override
    public Maze generate(int row, int col) {
        int[][] temp2DArr = new int[row][col];
        initArr(temp2DArr);
        Position startPos = createStartPosition(temp2DArr);
        Position goalPos = createGoalPosition(temp2DArr, startPos);
        makePath(startPos, goalPos, temp2DArr);
        randomizeWalls(temp2DArr);
        return new Maze(temp2DArr, startPos, goalPos);
    }

    private void initArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = 1;
    }

    private Position createStartPosition(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int i, j, applyValue;
        applyValue = (int) (Math.random() * 2); // choose what value to apply the const var between 2 options
        if (applyValue == 0)
            i = 0;
        else
            i = row - 1;
        j = 1 + (int) (Math.random() * (col - 2));
        arr[i][j] = 0;
        return new Position(i, j);
    }

    private Position createGoalPosition(int[][] arr, Position start) {
        int i = 0, j = 0;
        int row = arr.length;
        int col = arr[0].length;
        if (start.getRowIndex() == 0) {
            i = row - 1;
            j = 1 + (int) (Math.random() * (col - 2));
        }
        if (start.getRowIndex() == row - 1) {
            i = 0;
            j = 1 + (int) (Math.random() * (col - 2));
        }
        arr[i][j] = 0;
        return new Position(i, j);
    }

    private void makePath(Position startPosition, Position goalPosition, int[][] arr) {
        int i = 0, j = 0;
        if (startPosition.getRowIndex() == 0) {
            for (i = startPosition.getRowIndex() + 1; i < arr.length - 2; i++)
                arr[i][startPosition.getColumnIndex()] = 0;
            if ((startPosition.getColumnIndex() >= goalPosition.getColumnIndex()))
                for (j = startPosition.getColumnIndex(); j >= goalPosition.getColumnIndex(); j--)
                    arr[goalPosition.getRowIndex() - 1][j] = 0;
            else for (j = startPosition.getColumnIndex(); j <= goalPosition.getColumnIndex(); j++)
                arr[goalPosition.getRowIndex() - 1][j] = 0;
        }
        if (startPosition.getRowIndex() == arr.length - 1) {
            for (i = startPosition.getRowIndex() - 1; i > 0; i--)
                arr[i][startPosition.getColumnIndex()] = 0;
            if ((startPosition.getColumnIndex() >= goalPosition.getColumnIndex()))
                for (j = startPosition.getColumnIndex(); j >= goalPosition.getColumnIndex(); j--)
                    arr[goalPosition.getRowIndex()+1][j] = 0;
            else for (j = startPosition.getColumnIndex(); j <= goalPosition.getColumnIndex(); j++)
                arr[goalPosition.getRowIndex()+1][j] = 0;
        }
    }
        private void randomizeWalls ( int[][] arr){
            for (int i = 1; i < arr.length - 1; i++)
                for (int j = 1; j < arr[i].length - 1; j++)
                    if (arr[i][j] == 1)
                        arr[i][j] = (int) (Math.random() * 2);
        }

        public static void main (String[]args){
            IMazeGenerator sMaze = new SimpleMazeGenerator();
            Maze maze = sMaze.generate(10, 8);
            maze.print();
        }

    }