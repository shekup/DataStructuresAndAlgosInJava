package graphs;

import java.util.HashSet;
import java.util.Set;

public class GraphTest {

    public static void main(String[] args) throws Exception{

        BaseGraph graph = GraphBuilder.newGraph().buildGraph();

        Set nodes = new HashSet<Integer>();
        nodes.add(new Integer(1));
        nodes.add(new Integer(2));
        nodes.add(new Integer(3));
        nodes.add(new Integer(4));
        nodes.add(new Integer(5));
        graph.setNodes(nodes);
        Edge edge = new Edge(new Integer(1), new Integer(2));
        graph.setEdge(edge);
        edge = new Edge(new Integer(1), new Integer(3));
        graph.setEdge(edge);
        edge = new Edge(new Integer(2), new Integer(4));
        graph.setEdge(edge);
        edge = new Edge(new Integer(4), new Integer(5));
        graph.setEdge(edge);
        System.out.println(graph);

    }
}
