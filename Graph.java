package bd3;
import java.util.*;

public class Graph {
    private final int vertices; // Number of vertices
    private final List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge between two vertices
    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u); // Since it's an undirected graph
    }

    // Get adjacency list
    public List<Integer> getNeighbors(int v) {
        return adjacencyList.get(v);
    }

    // Get number of vertices
    public int getVertices() {
        return vertices;
    }

	public void greedyColoring() {
		// TODO Auto-generated method stub
		
	}
}
