package algorithms.mazeGenerators;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * testing gitttt blablabla Hello World
 *sfsfsfsfsfsfsfs
 * **/
public class SimpleMazeGenerator extends AMazeGenerator {
    public SimpleMazeGenerator() {
    }

    @Override

    public Maze generate(int row, int col) {
        int[][] temp2DArr = new int[row][col];
        initArr(temp2DArr);
    }

    private void initArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = 1;
    }

    private Position createStartPosition(int[][] arr) {
        int i, j, applyValue, row=arr.length, col=arr[0].length;
        int chooseConstVar = (int)(Math.random() * 2); // choose between i or j who will be the const
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
        arr[i][j] = 0;
        return new Position(i, j);
    }
    /*private Position createGoalPosition(int[][]arr, Position start){
        int i,j;
        if(start.getStartPosition()==0){

        }


    }
*/
    public static void main(String[] args) {
        IMazeGenerator sMaze = new SimpleMazeGenerator();
        Maze maze = sMaze.generate(10, 8);
        maze.print();
    }
}