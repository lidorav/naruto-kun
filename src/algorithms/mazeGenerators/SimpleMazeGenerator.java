package algorithms.mazeGenerators;

// Hello world How are you lidor? I am fine. Nice to meet you
public class SimpleMazeGenerator extends AMazeGenerator {
    public SimpleMazeGenerator() {
    }

    @Override
    public Maze generate(int row, int col) {
        int[][] temp2DArr = new int[row][col];
        initArr(temp2DArr);
        Position startPos = createStartPosition(temp2DArr);
        Position goalPos = createGoalPosition(temp2DArr,startPos);
        randomizeWalls(temp2DArr);
        return new Maze(temp2DArr,startPos,goalPos);
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
     private Position createGoalPosition(int[][] arr, Position start){
        int i=0,j=0;
        int row=arr.length;
        int col=arr[0].length;
        if(start.getRowIndex()==0){
            i = row - 1;
            j = 1 + (int) (Math.random() * (col - 2));
        }
         if(start.getRowIndex()==row-1){
             i = 0;
             j = 1 + (int) (Math.random() * (col - 2));
         }
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

    private void randomizeWalls(int [][] arr){
        for(int i=1 ;i<arr.length-1;i++)
            for(int j=1;j<arr[i].length-1;j++)
                if(arr[i][j]==1)
                    arr[i][j]=(int)(Math.random()*2);
    }

    public static void main(String[] args) {
        IMazeGenerator sMaze = new SimpleMazeGenerator();
        Maze maze = sMaze.generate(10, 8);
        maze.print();
    }

}