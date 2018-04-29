package algorithms.search;

import algorithms.mazeGenerators.*;

public class MazeState extends AState{
    private Position pos;

    public MazeState(Position pos, double price, MazeState prevState) {
        super(price,prevState);
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        MazeState ms = (MazeState) o;

        return (ms.getPos().getColumnIndex()==this.getPos().getColumnIndex() && ms.getPos().getRowIndex() == this.getPos().getRowIndex());
    }

    @Override
    public String toString() {
        return "MazeState{" +
                "pos=" + pos +
                '}';
    }
}
