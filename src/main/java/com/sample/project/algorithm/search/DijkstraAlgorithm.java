package com.sample.project.algorithm.search;

import com.sample.project.datastructure.Graph;

import java.util.*;

/**
 * Created by imteyaz.khan on 08/02/17.
 */
public class DijkstraAlgorithm<E> {

    private final static int ZERO_DISTANCE=0;
    private List<Graph.Edge> edges;
    private Set<Graph.Vertex> unSettledNodes;
    private Set<Graph.Vertex> settledNodes;
    private Map<Graph.Vertex,Integer> distances;
    private Map<Graph.Vertex,Graph.Vertex> predecessor;

    public DijkstraAlgorithm(Graph<E> graph) {
        this.edges=graph.getEdges();
    }

    public void compute(Graph.Vertex source) {
        unSettledNodes =new HashSet<>();
        settledNodes =new HashSet<>();
        distances=new HashMap<>();
        predecessor=new HashMap<>();

        unSettledNodes.add(source);
        distances.put(source,ZERO_DISTANCE);
        while(unSettledNodes.size()>0) {
            Graph.Vertex node=getVertexWithMinimumDistance(unSettledNodes);
            unSettledNodes.remove(node);
            settledNodes.add(node);
            findMinimumDistancePath(node);
        }
    }

    public List<Graph.Vertex> getMinimumDistancePathTo(Graph.Vertex destination) {

        Graph.Vertex step=predecessor.get(destination);
        if(step==null) {
            return null;
        }
        List<Graph.Vertex> paths=new ArrayList<>();
        paths.add(step);
        while(predecessor.get(step)!=null) {
            step=predecessor.get(step);
            paths.add(step);

        }
        Collections.reverse(paths);
        return paths;

    }
    private void findMinimumDistancePath(Graph.Vertex node) {
        Set<Graph.Vertex> neighbours=getUnSettledNeighbours(node);
        for (Graph.Vertex vertex:neighbours) {
            if(getShortestDistance(vertex) > getShortestDistance(node)+getDistance(node,vertex)) {
                distances.put(vertex,getShortestDistance(node)+getDistance(node,vertex));
                unSettledNodes.add(vertex);
                predecessor.put(vertex,node);
            }
        }
    }

    private Set<Graph.Vertex> getUnSettledNeighbours(Graph.Vertex vertex) {
        Set<Graph.Vertex> neighbours=new HashSet<>();
        for(Graph.Edge edge:edges) {
            if(edge.getSource().equals(vertex) && !settledNodes.contains(edge.getDestination())) {
                neighbours.add(edge.getDestination());
            }
        }
        return neighbours;
    }

    private Graph.Vertex getVertexWithMinimumDistance(Set<Graph.Vertex> vertexes) {
        Graph.Vertex minimum=null;
        for(Graph.Vertex vertex:vertexes) {
            if(minimum==null) {
                minimum=vertex;
            } else if(getShortestDistance(vertex)<getShortestDistance(minimum)) {
                minimum=vertex;
            }
        }
        return minimum;
    }

    private int getDistance(Graph.Vertex source,Graph.Vertex destination) {
        for(Graph.Edge edge:edges) {
            if(edge.getSource().equals(source) && edge.getDestination().equals(destination)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Node missing");
    }
    private int getShortestDistance(Graph.Vertex vertex) {
        Integer distance=distances.get(vertex);
        if(distance==null) {
            return Integer.MAX_VALUE;
        }
        return distance;
    }

}
