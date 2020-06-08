package bfs.canFinish;


import java.util.*;

public class Solution {
    public boolean validTree(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0 ) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if(!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result.add(node);
            if (map.containsKey(node)) {
                for (Integer neighbour: map.get(node)) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        queue.offer(neighbour);
                    }
                }
            }

        }
        return result.size() == numCourses;
    }
}
