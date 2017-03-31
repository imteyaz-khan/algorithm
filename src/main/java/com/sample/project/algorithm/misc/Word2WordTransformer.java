package com.sample.project.algorithm.misc;

import com.sample.project.datastructure.Graph;
import com.sample.project.datastructure.Queue;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by imteyaz.khan on 13/03/17.
 */
public class Word2WordTransformer {

    private Map<String,Graph.Vertex<String>> wordsNodeMap;
    private List<Graph.Vertex<String>> vertexes;
    private List<Graph.Edge> edges;

    public Word2WordTransformer(List<String> words) {
        wordsNodeMap=new HashMap<>();
        vertexes=new ArrayList<>();
        edges=new ArrayList<>();
        buildDictionaryGraphAndPopulateReferenceMap(words);
    }
    //this method return if from source word to target word exists
    public boolean hasPath(String source,String target) {

        Graph.Vertex<String> sourceVertex=wordsNodeMap.get(source);
        Graph.Vertex<String> targetVertex=wordsNodeMap.get(target);
        if(sourceVertex==null||targetVertex==null) {
            return false;
        }
        return hasPath(sourceVertex,targetVertex,new HashSet<>());
    }

    private boolean hasPath(Graph.Vertex<String> source,Graph.Vertex<String> target,Set<Graph.Vertex<String>> visited) {
        List<Graph.Vertex> neighbours=getNeighbours(source, visited);
        visited.add(source);
        for(Graph.Vertex vertex:neighbours) {
            if(vertex.equals(target)) {
                return true;
            }
        }

        for(Graph.Vertex vertex:neighbours) {
            if(hasPath(vertex,target,visited)) {
                return true;
            }
        }
        return false;
    }


    private void buildDictionaryGraphAndPopulateReferenceMap(List<String> words) {
       words.forEach(this::addToGraph);
    }

    private List<Graph.Vertex> getNeighbours(Graph.Vertex<String> source,Set<Graph.Vertex<String>> visited) {
        return edges.stream().filter(e->e.getSource().equals(source) && !visited.contains(source))
                .map(Graph.Edge::getDestination).collect(Collectors.toList());
    }
    // adding this word to right place and making sure it is connected to all the nodes to whom diff of character
    //is one
    private void addToGraph(String word) {
        Graph.Vertex<String> vertex = new Graph.Vertex<>(word);
        List<Graph.Vertex<String>> neighbours=getWouldBeNeighboursNodes(word);
        neighbours.forEach(v->{
            edges.add(new Graph.Edge(v.getElement().toLowerCase()+"-"+vertex.getElement(),
                    v,vertex,0));
            edges.add(new Graph.Edge(vertex.getElement()+"-"+v.getElement().toLowerCase(),
                    vertex,v,0));
        });
        vertexes.add(vertex);
        wordsNodeMap.put(word,vertex);
    }

    private List<Graph.Vertex<String>> getWouldBeNeighboursNodes(String word) {
        return vertexes.stream().filter(v->match(word,v)).collect(Collectors.toList());
    }

    private boolean match(String word,Graph.Vertex<String> vertex) {
        if (word.length() != vertex.getElement().length()) {
            return false;
        }
        int charDiffCount = 0;
        for (int index = 0; index < word.length(); index++) {
            if (word.charAt(index) != vertex.getElement().charAt(index)) {
                charDiffCount++;
                if (charDiffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
