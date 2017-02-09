package com.sample.project.algorithm.search;

import com.sample.project.datastructure.Graph;
import com.sample.project.datastructure.Graph.Vertex;

import com.sample.project.datastructure.LinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by imteyaz.khan on 09/02/17.
 */
public class DijkstraAlgorithmTest {

    @Test
    public void testExcute() {
        List<Graph.Vertex >  nodes= new ArrayList<>();
        List<Graph.Edge>  edges = new ArrayList<>();
        Graph<String> graph = new Graph<String>(nodes, edges);
        for (int i = 0; i < 11; i++) {
            Graph.Vertex location = new Vertex("Node_" + i);
            nodes.add(location);
        }

        edges.add(createEdge("Edge_0", nodes.get(0), nodes.get(1), 85));
        edges.add(createEdge("Edge_1", nodes.get(0), nodes.get(2), 217));
        edges.add(createEdge("Edge_2", nodes.get(0), nodes.get(4), 173));
        edges.add(createEdge("Edge_3", nodes.get(2), nodes.get(6), 186));
        edges.add(createEdge("Edge_4", nodes.get(2), nodes.get(7), 103));
        edges.add(createEdge("Edge_5", nodes.get(3), nodes.get(7), 183));
        edges.add(createEdge("Edge_6", nodes.get(5), nodes.get(8), 250));
        edges.add(createEdge("Edge_7", nodes.get(8), nodes.get(9), 84));
        edges.add(createEdge("Edge_8", nodes.get(7), nodes.get(9), 167));
        edges.add(createEdge("Edge_9", nodes.get(4), nodes.get(9), 502));
        edges.add(createEdge("Edge_10", nodes.get(9), nodes.get(10), 40));
        edges.add(createEdge("Edge_11", nodes.get(1), nodes.get(10), 600));


        DijkstraAlgorithm<String> dijkstra = new DijkstraAlgorithm<String>(graph);
        dijkstra.compute(nodes.get(0));
        List<Graph.Vertex> path = dijkstra.getMinimumDistancePathTo(nodes.get(10));

        for (Graph.Vertex vertex : path) {
            System.out.println(vertex);
        }
        assertNotNull(path);
        assertTrue(path.size() > 0);



    }

    private Graph.Edge createEdge(String id, Graph.Vertex source,Graph.Vertex destination,
                         int duration) {
        return new Graph.Edge(id,source,destination, duration );
    }
}
