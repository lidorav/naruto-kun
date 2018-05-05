package algorithms.search;
import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {


    public BestFirstSearch() {
        Comparator<AState> comparator = (o1, o2) -> {
            if (o1.getCost() > o2.getCost())
                return 1;
            if (o1.getCost() < o2.getCost())
                return -1;

            return 0;
        };
        openQ=new PriorityQueue<AState>(comparator);

    }
        @Override
        public Solution solve(ISearchable domain){
        return super.solve(domain);

    }



}
