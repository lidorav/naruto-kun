package algorithms.mazeGenerators;

/**
 * A class that represent a position in a 2D grid, it contains the row number and the column number.
 */
public class Position {
    private int row;
    private int col;

    /**
     * C'tor - Creates a position with a given coordinates.
     * @param row the row number on the grid
     * @param col the column number on the grid
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * @return the row index of the position
     */
    public int getRowIndex(){
       return this.row;
   }

    /**
     * @return the column index of the position
     */
   public int getColumnIndex(){
       return this.col;
   }

    /**
     * @return a string representing the position {row,col}
     */
    @Override
    public String toString() {
        return "" + '{' + row + "," + col + '}';
    }
}
