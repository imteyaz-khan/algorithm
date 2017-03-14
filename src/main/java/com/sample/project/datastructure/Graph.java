package com.sample.project.datastructure;

import java.util.List;

/**
 * Created by imteyaz.khan on 07/02/17.
 */
public class Graph {
    private List<Vertex> vertexes;
    private List<Edge> edges;

    public Graph(List<Vertex> vertexes,List<Edge> edges) {
        this.vertexes=vertexes;
        this.edges=edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Graph{");
        sb.append("vertexes=").append(vertexes);
        sb.append(", edges=").append(edges);
        sb.append('}');
        return sb.toString();
    }

    public static class Vertex {
        private Object element;

        public Vertex(Object element) {
            this.element = element;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            if (element != null ? !element.equals(vertex.element) : vertex.element != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return element != null ? element.hashCode() : 0;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Vertex{");
            sb.append("element=").append(element);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Edge {
        private String id;
        private Vertex source;
        private Vertex destination;
        private int weight;

        public Edge(String id, Vertex source, Vertex destination, int weight) {
            this.id = id;
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public String getId() {
            return id;
        }

        public Vertex getSource() {
            return source;
        }

        public Vertex getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Edge{");
            sb.append("source=").append(source);
            sb.append(", destination=").append(destination);
            sb.append('}');
            return sb.toString();
        }
    }
}
