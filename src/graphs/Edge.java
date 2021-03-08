package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;

/*
This is the base edge class
More types of edges (Directed, Weighted, etc.) will extend this class
 */
public class Edge {

    private Integer node1;
    private Integer node2;
    private Integer[] nodes;

    public Edge(Integer node1, Integer node2){
        this.node1 = Utility.checkNotNull(node1);
        this.node2 = Utility.checkNotNull(node2);
        nodes = new Integer[2];
        nodes[0] = node1;
        nodes[1] = node2;
    }

    public Integer[] getNodes(){
        return nodes;
    }


}
