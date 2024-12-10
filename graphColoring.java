package bd3;
import java.util.*;

public class GraphColoring {

    // Greedy coloring algorithm
    public static int[] colorGraph(Graph graph) {
        int vertices = graph.getVertices();
        int[] result = new int[vertices]; // Stores the assigned color for each vertex
        Arrays.fill(result, -1); // Initially, no vertex has a color assigned

        boolean[] availableColors = new boolean[vertices]; // Track available colors for a vertex

        // Assign the first color to the first vertex
        result[0] = 0;

        // Assign colors to remaining vertices
        for (int u = 1; u < vertices; u++) {
            // Mark colors of all adjacent vertices as unavailable
            Arrays.fill(availableColors, true);
            for (int neighbor : graph.getNeighbors(u)) {
                if (result[neighbor] != -1) {
                    availableColors[result[neighbor]] = false;
                }
            }

            // Find the first available color
            int color;
            for (color = 0; color < vertices; color++) {
                if (availableColors[color]) {
                    break;
                }
            }

            result[u] = color; // Assign the found color to the current vertex
        }

        return result;
    }
}
