package algorithms.search;

import algorithms.mazeGenerators.*;

/**
 * A class that represent an actual state of a maze, it contains the position on the maze.
 */
public class MazeState extends AState{
    private Position pos;

    /**
     * C'tor - creates a maze state.
     * @param pos the position on the maze in that state
     * @param price the price cost to progress that state
     * @param prevState from where we came from - who is the father of that state.
     */
    public MazeState(Position pos, double price, MazeState prevState) {
        super(price,prevState);
        this.pos = pos;
    }

    /**
     * @return the position of the maze in that state
     */
    public Position getPos() {
        return pos;
    }

    /**
     * Compare between 2 maze states
     * @param o the other state
     * @return true if they equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        MazeState ms = (MazeState) o;
        return (ms.getPos().getColumnIndex()==this.getPos().getColumnIndex() && ms.getPos().getRowIndex() == this.getPos().getRowIndex());
    }

    /**
     * @return hash code of the maze state (created from his position)
     */
    @Override
    public int hashCode() {
        return pos!=null ? pos.toString().hashCode() : 0;
    }

    /**
     * @return the string describing the maze state (his position)
     */
    @Override
    public String toString() {
        return "MazeState{" +
                "pos=" + pos +
                '}';
    }
}
