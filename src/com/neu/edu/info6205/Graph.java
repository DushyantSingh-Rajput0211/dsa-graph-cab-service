package com.neu.edu.info6205;

import java.util.*;

class Graph {
    private int V; //Vertices or stops
    private LinkedList<Edge>[] adj;

    Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w, int distance) {
        adj[v].add(new Edge(w, distance));
    }

    boolean Util(int v, boolean visited[], int destination, List<Integer> path, Map<Integer, Integer> distances) {
        visited[v] = true;
        path.add(v);

        if (v == destination)
            return true;

        Iterator<Edge> i = adj[v].listIterator();
        while (i.hasNext()) {
            Edge edge = i.next();
            int n = edge.destination;
            if (!visited[n]) {
                distances.put(n, distances.getOrDefault(v, 0) + edge.distance);
                boolean found = Util(n, visited, destination, path, distances);
                if (found)
                    return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    boolean RouteSearch(int v, int destination, List<Integer> path, Map<Integer, Integer> distances) {
        boolean visited[] = new boolean[V];
        return Util(v, visited, destination, path, distances);
    }
}

class Edge {
    int destination;
    int distance;

    Edge(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

class RedEyeService {
    static void findPath(String[] dropOffLocations, int[][] points, int source, int destination) {
        int numLocations = dropOffLocations.length;
        Graph graph = new Graph(numLocations);

        for (int i = 0; i < points.length; i++) {
            int from = points[i][0];
            int to = points[i][1];
            int distance = points[i][2];
            graph.addEdge(from, to, distance);
            graph.addEdge(to, from, distance);
        }

        List<Integer> path = new ArrayList<>();
        Map<Integer, Integer> distances = new HashMap<>();
        boolean found = graph.RouteSearch(source, destination, path, distances);

        if (found) {
            System.out.println("\nThe order in which the drop-off locations would be covered is: ");
            System.out.println();
            for (int node : path) {
                System.out.print(dropOffLocations[node]+" --> ");
            }
            int totalDistance = distances.get(destination);
            System.out.println("\nTotal distance covered in the trip: " + totalDistance + " miles.");
        } else {
            System.out.println("\nDestination not reachable from source.");
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String[] dropOffLocations = {
                "Northeastern University", // Point 0
                "The Viridian", // Point 1
                "One Back Bay", // Point 2
                "JVUE at the LMA", // Point 3
                "The Arlington", // Point 4
                "Troy Boston", // Point 5
                "30 Dalton", // Point 6
                "Longwood Apartments", // Point 7
                "HarborView at the Navy Yard", // Point 8
                "Waterside Place", // Point 9
                "Avalon at Prudential Center", // Point 10
                "Avalon North Station", // Point 11
                "Harbor Towers", // Point 12
                "The Victor", // Point 13
        };

        //Dataset
        int[][] points = {
                {0, 1, 3}, // Northeastern University to The Viridian
                {0, 2, 2}, // Northeastern University to One Back Bay
                {1, 2, 4}, // The Viridian to One Back Bay
                {1, 3, 9}, // The Viridian to JVUE at the LMA
                {2, 4, 7}, // One Back Bay to Longwood Apartments
                {2, 5, 6}, // One Back Bay to Troy Boston
                {2, 10, 4}, // One Back Bay to Waterside Place
                {3, 4, 2}, // JVUE at the LMA to Longwood Apartments
                {3, 5, 5}, // JVUE at the LMA to HarborView at the Navy Yard
                {3, 8, 3}, // JVUE at the LMA to Avalon at Prudential Center
                {5, 7, 8}, // Troy Boston to Avalon at Prudential Center
                {5, 6, 1}, // Troy Boston to Avalon North Station
                {6, 7, 2}, // 30 Dalton to Harbor Towers
                {7, 8, 3}, // HarborView at the Navy Yard to The Victor
                {10, 11, 2}, // Waterside Place to Avalon North Station
                {10, 12, 3}, // Waterside Place to Harbor Towers
                {10, 13, 3}, // Waterside Place to The Victor
                {11, 13, 5}, // Avalon North Station to The Victor
                {12, 13, 6}, // Harbor Towers to The Victor
        };

        int source = 0; //Red Eye will always start from Northeastern University

        System.out.println("Enter the destination index:");
        int destination = scanner.nextInt();

        try{
            findPath(dropOffLocations, points, source, destination);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}