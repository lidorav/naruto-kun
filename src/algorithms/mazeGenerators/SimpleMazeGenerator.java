package algorithms.mazeGenerators;

import javafx.geometry.Pos;

public class SimpleMazeGenerator extends AMazeGenerator {
    public SimpleMazeGenerator() {
    }

    @Override
    public Maze generate(int row, int col) {
        int[][] temp2DArr = new int[row][col];
        initArr(temp2DArr);
        Position startPos = createPosition(temp2DArr);
        Position goalPos = createPosition(temp2DArr);
        makePath(startPos,goalPos, temp2DArr);
        return new Maze(temp2DArr,startPos,goalPos);
    }

    private void initArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = 1;
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
            }return new Position(i, j);
        } while (arr[i][j] == 0);
        arr[i][j] = 0;

     }

    private void makePath(Position startPosition,Position goalPosition,int [][]arr){
        int verticalSteps = startPosition.getRowIndex() - goalPosition.getRowIndex();
        int horizontalSteps = startPosition.getColumnIndex() - goalPosition.getColumnIndex();
        int i=0,j=0;
        if (verticalSteps<0)
            for (i=startPosition.getRowIndex()+1;i<arr.length-1;i++){
                arr[i][startPosition.getColumnIndex()] = 0;
            }
        if (verticalSteps>0)
            for (i=startPosition.getRowIndex();i>0;i--){
                arr[i][startPosition.getColumnIndex()]=0;
            }
        if (horizontalSteps<0)
            for (j=startPosition.getColumnIndex();j<=Math.abs(horizontalSteps);j++){
                arr[i][j]=0;
            }
        if (horizontalSteps>0)
            for (j=startPosition.getColumnIndex();j>=horizontalSteps;j--){
                arr[i][startPosition.getColumnIndex()]=0;
            }
    }

    public static void main(String[] args) {
        IMazeGenerator sMaze = new SimpleMazeGenerator();
        Maze maze = sMaze.generate(10, 8);
        maze.print();
    }

}