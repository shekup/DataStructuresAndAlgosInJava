package graphs;

public final class GraphBuilder {

    private boolean isDirected;

    private boolean isWeighted;

    public static GraphBuilder newGraph() {
        return new GraphBuilder();
    }

    public GraphBuilder isDirected(){
        this.isDirected = true;
        return this;
    }

    public GraphBuilder isWeighted(){
        this.isWeighted = true;
        return this;
    }

    /**
     * this method will check the values of isDirected, isWeighted, etc. and returns appropriate Graph object
     * @return
     */
    public BaseGraph buildGraph(){
        BaseGraph baseGraph = new BaseGraph();
        return baseGraph;
    }

}
