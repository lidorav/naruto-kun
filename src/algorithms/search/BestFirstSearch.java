package algorithms.search;
import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {

    public BestFirstSearch() {
        PriorityQueue openQ=new PriorityQueue<>();
        Comparator<AState> comparator = new Comparator<AState>() {
            @Override
            public int compare(AState o1, AState o2) {
                if (o1.getCost() > o2.getCost())
                    return 1;
                if (o1.getCost() < o2.getCost())
                    return -1;

                return 0;
            }
        };
        openQ = new PriorityQueue<AState>(comparator);


    }

    public Solution solve(ISearchable domain){
        return super.solve(domain);

    }




}
