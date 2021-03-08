package graphs;

import java.util.*;

/**
 * Graph has number of vertices and each vertex can be connected to any number of other vertices in graph
 * The edges don't have direction and no weight
 * For example, if graph has 5 edges then each edge maintains a list of edges it is connected
 * Node 1 -> Node 2, Node 3, Node 5
 * Node 2 -> Node 1, Node 4
 * Node 3 -> Node 1, Node 5
 * Node 4 -> Node 2
 * Node 5 -> Node 1, Node 3
 *
 * The benefit of using <N> instead of Node is BaseGraph can be initialized to hold anything like String, int, or Node
 */
public class BaseGraph implements Graph{

    private Map<Integer, List<Integer>> adjVertices;
    private Integer rootNode;

    public BaseGraph(){
        this.adjVertices = new HashMap<Integer, List<Integer>>();
    }

    public BaseGraph(Integer n){
        this.rootNode = Utility.checkNotNull(n);
    }

    public Set<Integer> nodes(){
        return adjVertices.keySet();
    }

    public void setNodes(Set<Integer> nodes){
        if(rootNode == null){
            this.rootNode = Utility.checkNotNull(nodes.iterator().next());
        }
        for(Integer n: nodes){
            adjVertices.put(n, new ArrayList<Integer>());
        }
    }

    public void setEdge(Edge edge) throws Exception{
        Integer[] nodes = edge.getNodes();
        Integer node1 = nodes[0];
        Integer node2 = nodes[1];
        if( (!(adjVertices.containsKey(node1))) || (!(adjVertices.containsKey(node2))))
            throw new Exception("node does not exist");
        adjVertices.get(node1).add(node2);
        adjVertices.get(node2).add(node1);
    }

    public String toString(){
        return adjVertices.toString();
    }

}
