package algorithms.mazeGenerators;

import algorithms.search.ISearchable;
import algorithms.search.MazeState;

import java.util.ArrayList;
import java.util.List;

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


