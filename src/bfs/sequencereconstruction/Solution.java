package bfs.sequencereconstruction;

import java.util.*;

public class Solution implements sequenceReconstruction{
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        int n = org.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        for (int[] sequence:seqs) {
            for (int num: sequence) {
                if (num < 0 || num > n) {
                    return false;
                }
                nodes.add(num);
            }
        }

        for (int node : nodes) {
            inDegree.put(node, 0);
            graph.put(node, new ArrayList<>());
        }

        for (int[] sequence : seqs) {
            for (int i = 1; i < sequence.length; i++) {
                graph.get(sequence[i - 1]).add(sequence[i]);
                inDegree.put(sequence[i], inDegree.get(sequence[i]) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry entry : inDegree.entrySet()) {
            if ((int)entry.getValue() == 0) {
                queue.offer((Integer)entry.getKey());
            }
        }

        int counter = 0;
        while (queue.size() == 1) {
            Integer node = queue.poll();
            if (node != org[counter]) {
                return false;
            }
            counter++;
            for (int neighbour : graph.get(node)) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if (inDegree.get(neighbour) == 0 ) {
                    queue.offer(neighbour);
                }
            }
        }

        return counter == org.length;
    }
}
