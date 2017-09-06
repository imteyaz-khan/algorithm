package com.sample.project.algorithm.search;

import com.sample.project.datastructure.Queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by imteyaz.khan on 18/08/17.
 */
public class Dijkstra {
    public int getMinimumDistancePath(int graph[][],int source,int destination) {
        if(graph==null||source<0 || source >graph.length||destination<0||destination >graph.length) {
            return Integer.MAX_VALUE;
        }

        Set<Integer> visited=new HashSet<>();
        Queue<Integer> nodes=new Queue<>();
        int dist[]=new int[graph.length];
        dist[source]=0;
        nodes.enqueue(source);
        for(int index=0;index<graph.length;index++) {
            if(index!=source) {
                nodes.enqueue(index);
                dist[index]=Integer.MAX_VALUE;
            }
        }
        Map<Integer,Integer> paths=new HashMap<>();
        while(nodes.isEmpty()) {
            int vertex=nodes.dequeue();
            if(!visited.contains(vertex)) {
                for(int index=0;index<graph.length;index++ ) {
                    if(graph[vertex][index]>=0 && (dist[index]> dist[vertex]+graph[vertex][index])) {
                        dist[index]=dist[vertex]+graph[vertex][index];
                        paths.put(index,vertex);
                    }
                }
                visited.add(vertex);
            }
        }
        int traveller=destination;
        while(paths.containsKey(traveller)) {
            traveller=paths.get(traveller);
            System.out.print(traveller+"<-");

        }
        System.out.println();
        return dist[destination];
    }

    public static void main(String args[]) {
        int graph[][]={
                {0,2,3,-1,-1,-1,-1},
                {2,0,-1,2,2,-1,-1},
                {3,-1,0,1,-1,-1,7},
                {5,5,1,0,3,-1,2},
                {-1,2,-1,3,0,1,2},
                {-1,-1,-1,-1,1,0,5},
                {-1,-1,7,2,2,5,0}
        };

        Dijkstra dijkstra=new Dijkstra();
        System.out.println(dijkstra.getMinimumDistancePath(graph,0,5));
    }
}
