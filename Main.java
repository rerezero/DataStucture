package bd3;


public class Main {
    public static void main(String[] args) {
        // Create a graph with 10 vertices
        Graph graph = new Graph(10);

        // Add edges to the graph (a more complex graph structure)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(6, 9);
        graph.addEdge(3, 7);
        graph.addEdge(1, 8);

        // Perform graph coloring
        int[] colors = GraphColoring.colorGraph(graph);

        // Display the results
        System.out.println("Vertex : Color");
        for (int i = 0; i < colors.length; i++) {
        	System.out.println("Vertex " + i + " is colored with color " + colors[i]);

        }
    }
}


//	0 -- 1 -- 3 -- 5 -- 7
//	 \  /     |    |    |
//	   2      4 -- 6 --  8 -- 9
//	                \        /
