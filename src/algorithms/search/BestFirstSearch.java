package algorithms.search;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class BestFirstSearch extends ASearchingAlgorithm  {
    private PriorityQueue<AState> open;

    public BestFirstSearch(){
        super();
        // declares new priority queue
        open= new PriorityQueue();
    }

    @Override
    public Solution solve(ISearchable domain) {
        return null;
    }

}
