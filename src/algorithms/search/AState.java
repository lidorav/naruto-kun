package algorithms.search;

/**
 * Abstract class that represent a state in the domain.
 * It contains the cost of the state, from where it came from and if he already been visited.
 */
public abstract class AState {
    private double cost;
    private AState cameFrom;

    /**
     * C'tor - Creates a state
     * @param cost the price to move to that state
     * @param cameFrom from which state we came from
     */
    public AState(double cost, AState cameFrom) {
        this.cost = cost;
        this.cameFrom = cameFrom;
    }


    /**
     * @return the state price
     */
    public double getCost() {
        return cost;
    }

    /**
     * @return the state we came from
     */
    public AState getCameFrom() {
        return cameFrom;
    }

    /**
     * Set the state "father", from what state where we came
     * @param cameFrom the previous state
     */
    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    /**
     * define equality between 2 states
     * @param o the other state
     * @return true if the 2 states equal, false otherwise
     */
    public abstract boolean equals(Object o);
}
