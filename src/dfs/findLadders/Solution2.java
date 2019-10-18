package dfs.findLadders;

import java.util.*;

public class Solution2 implements findLadders{
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        dict.add(start);
        dict.add(end);
        Map<String, Set<String>> forwardGraph = new HashMap<>();
        distanceFrom(end, dict, forwardGraph);
        List<List<String>> results = new ArrayList<>();
        dfs(start, end, new ArrayList<>(), results, forwardGraph);
        return results;
    }

    private void dfs(String start, String end, List<String> path, List<List<String>> results, Map<String, Set<String>> graph) {
        path.add(start);
        if (start.equals(end)) {
            results.add(new ArrayList<>(path));
        } else {
            for (String next: graph.get(start)) {
                dfs(next, end, path, results, graph);
            }
        }
        path.remove(path.size() - 1);
    }

    private void distanceFrom(String beginPoint,
                              Set<String> dict,
                              Map<String, Set<String>> forwardGraph) {
        Map<String, Integer> dists = new HashMap<>(); // shortest distance from beginPoint
        Queue<String> queue = new LinkedList<>();
        dists.put(beginPoint, 0);
        queue.offer(beginPoint);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int dist = dists.get(curr) + 1;
            for (String next: expand(curr, dict)) {
                if (!dists.containsKey(next)) { // not visited so far
                    queue.offer(next);
                }
                //Has not been visited or visited from the current level -- meaning it is on the shortest paths
                //If was visited in previous level, then current node is not on the shortest paths
                if (!dists.containsKey(next) || dists.get(next) == dist) {
                    dists.put(next, dist);
                    if (!forwardGraph.containsKey(next)) {
                        forwardGraph.put(next, new HashSet<>());
                    }
                    forwardGraph.get(next).add(curr);
                }
            }
        }
    }

    private Set<String> expand(String word, Set<String> dict) {
        Set<String> results = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) != c) {
                    String newWord = word.substring(0, i) + c + word.substring(i + 1);
                    if (dict.contains(newWord)) {
                        results.add(newWord);
                    }
                }
            }
        }
        return results;
    }
}
