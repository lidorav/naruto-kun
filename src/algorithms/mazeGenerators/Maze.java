package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {
    private int [][] m_2DArr;
    private Position startPosition;
    private Position goalPosition;

    public Maze(int[][] m_2DArr, Position startPosition, Position goalPosition) {
        this.m_2DArr = m_2DArr;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
    }

    public int[][] getM_2DArr() {
        return m_2DArr;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getGoalPosition() {
        return goalPosition;
    }

    public void print()
    {
        for(int i=0;i<m_2DArr.length;i++)
            System.out.println(Arrays.toString(m_2DArr[i])+"\n");
    }

}


