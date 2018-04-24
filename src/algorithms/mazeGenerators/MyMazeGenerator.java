package algorithms.mazeGenerators;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    private int[][] map;
    private List<Pair<Position, Position>> walls;
    private int width;
    private int height;

    public MyMazeGenerator() {
    }

    /**
     * Main function to generate
     *
     * @param row
     * @param col
     * @return
     */
    public Maze generate(int row, int col) {
        init(row, col);
        Random rand1 = new Random();
        Random rand2 = new Random();

        // Pick a random grid first
        int cell_row = rand1.nextInt(height - 3) + 1;
        int cell_col = rand2.nextInt(width - 3) + 1;
        map[cell_row][cell_col] = 0;
        addWalls(cell_row, cell_col);
        while (!walls.isEmpty()) {
            //Pick a random wall
            Random rindex = new Random();
            int index = rindex.nextInt(walls.size());
            int wall_row = walls.get(index).getKey().getRowIndex();
            int wall_col = walls.get(index).getKey().getColumnIndex();
            cell_row = walls.get(index).getValue().getRowIndex();
            cell_col = walls.get(index).getValue().getColumnIndex();
            walls.remove(index);

            //Skip if it is no longer a wall
            if (map[wall_row][wall_col] != 1)
                continue;

            //Skip if the two cells that the wall divides are visited
            if (map[cell_row][cell_col] == 0)
                continue;

            //Make the two grid as passages
            map[wall_row][wall_col] = 0;
            map[cell_row][cell_col] = 0;

            //Add the neighboring walls
            addWalls(cell_row, cell_col);
        }
        fillEdgeWalls();
        Position startP = chooseStartPoint();
        Position endP = chooseExitPoint();
        return new Maze(map, startP, endP);
    }

    private void init(int row, int col) {
        //initialize variables
        height = row;
        width = col;
        map = new int[height][width];
        walls = new ArrayList<>();

        // Fill the maze with walls
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                map[i][j] = 1;
    }

    /**
     * Check if the given wall position is in the maze and not on the boundary
     *
     * @param row row index
     * @param col column index
     * @return true if the coordinates in the maze, false otherwise
     */
    private boolean checkWallInMaze(int row, int col) {
        return row > 0 && row < height - 1 && col > 0 && col < width - 1;
    }

    /**
     * Check if the given cell position is in the maze and not on the boundary
     *
     * @param row row index
     * @param col column index
     * @return true if the coordinates in the maze, false otherwise
     */
    private boolean checkCellInMaze(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }

    /**
     * Add the neighboring walls of the cell (row, col) to the wall list
     *
     * @param row row index of the cell
     * @param col column index of the cell
     */
    private void addWalls(int row, int col) {

        //It's a 4-connected grid maze
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int wall_row, wall_col, cell_row, cell_col;

        for (int i = 0; i < dir.length; i++) {
            //Calculate the neighboring wall position and the cell position
            wall_row = row + dir[i][0];
            wall_col = col + dir[i][1];
            cell_row = wall_row + dir[i][0];
            cell_col = wall_col + dir[i][1];

            //Make sure the wall grid is in the range of the maze
            if ((!(checkWallInMaze(wall_row, wall_col)) || (!(checkCellInMaze(cell_row, cell_col)))))
                continue;

            //Add the wall and the neighboring cell to the list
            walls.add(new Pair<>(new Position(wall_row, wall_col), new Position(cell_row, cell_col)));
        }
    }

    /**
     * Creates the outer walls of the maze
     */
    private void fillEdgeWalls() {
        for (int i = 0; i < height; i++) {
            map[i][0] = 1;
            map[i][width - 1] = 1;
        }
        for (int j = 0; j < width; j++) {
            map[0][j] = 1;
            map[height - 1][j] = 1;
        }
    }

    /**
     * Choose the exit point out of the maze and mark it on the maze
     *
     * @return the exit position
     */
    private Position chooseExitPoint() {
        for (int i = height - 1; i > 0; i--) {
            if (map[i][width - 2] == 0) {
                map[i][width - 1] = 0;
                return new Position(i, width - 1);
            }
        }
        return null;
    }

    /**
     * Choose the start point out of the maze and mark it on the maze
     *
     * @return the start position
     */
    private Position chooseStartPoint() {
        for (int i = 1; i < height - 1; i++) {
            if (map[i][1] == 0) {
                map[i][0] = 0;
                return new Position(i, 0);
            }
        }
        return null;
    }
}
