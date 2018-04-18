package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazeGenerator {
    public SimpleMazeGenerator() {
    }

    @Override
    public Maze generate(int row, int col) {
        int[][] temp2DArr = new int[row][col];
        initArr(temp2DArr);
        Position startPos = createPosition(temp2DArr);
        Position goalPos = createPosition(temp2DArr);
        pathGradient(temp2DArr,startPos,goalPos);
        return new Maze(temp2DArr,startPos,goalPos);
    }

    private void initArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = 1;
    }
    private Position createStartPosition(int row, int col){
        int i= (int)Math.random()*2;
    return null;
    }

    private Position createPosition(int[][] arr) {
        int row=arr.length;
        int col=arr[0].length;
        int i, j, applyValue;
        int chooseConstVar = (int)(Math.random() * 2); // choose between i or j who will be the const
        do {
            if (chooseConstVar == 0) {
                applyValue = (int)(Math.random() * 2); // choose what value to apply the const var between 2 options
                if (applyValue == 0)
                    i = 0;
                else
                    i = row-1;
                j = 1 + (int) (Math.random() * (col - 2));
            } else {
                applyValue = (int) Math.random() * 2; // choose what value to apply the const var between 2 options
                if (applyValue == 0)
                    j = 0;
                else
                    j = col-1;
                i = 1 + (int) (Math.random() * (row - 2));
            }
        } while (arr[i][j] == 0);
        arr[i][j] = 0;
        return new Position(i, j);
     }

    private void pathGradient (int [][]arr, Position startPosition, Position goalPosition) {

        int rowPath = startPosition.getRowIndex() - goalPosition.getRowIndex();
        int colPath = startPosition.getColumnIndex() - goalPosition.getColumnIndex();
        makePath(startPosition.getRowIndex(),startPosition.getColumnIndex(), rowPath,colPath ,arr);
    }

    private void makePath(int startRow, int startCol, int verticalSteps, int horiznalSteps, int [][]arr){
        int i=0,j=0;
        if (verticalSteps<0)
            for (i=startRow+1;i<arr.length-1;i++){
                arr[i][startCol] = 0;
            }
        if (verticalSteps>0)
            for (i=startRow-1;i<verticalSteps;i--){
                arr[i][startCol]=0;
            }
        if (horiznalSteps<0)
            for (j=startCol;j<horiznalSteps;j++){
                arr[i][startCol]=0;
            }
        if (verticalSteps>0)
            for (j=startCol;j<horiznalSteps;j--){
                arr[i][startCol]=0;
            }
    }

    public static void main(String[] args) {
        IMazeGenerator sMaze = new SimpleMazeGenerator();
        Maze maze = sMaze.generate(10, 8);
        maze.print();
    }

}