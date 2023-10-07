package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstSearch {


    public static void main(String[] args) {
        // Constructing graph using adjacency list

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        List<Integer> output = bfsOnGraph(5, adj);
        System.out.println(output);
    }

    private static List<Integer> bfsOnGraph(int i, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[i];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // adding index-0 for graph data structure.
        vis[0] = true;

        while (!queue.isEmpty()) {
            Integer val = queue.poll();
            bfs.add(val);
            for (Integer it: adj.get(val)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }
        return bfs;
    }

}
