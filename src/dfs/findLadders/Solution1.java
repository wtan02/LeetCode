package dfs.findLadders;

import java.util.*;

public class Solution1 implements findLadders {
    public List<List<String>> findLadders(String start, String end,
                                          Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);

        bfs(map, distance, end, dict);

        List<String> path = new ArrayList<String>();

        dfs(ladders, path, start, end, distance, map);

        return ladders;
    }

    void dfs(List<List<String>> ladders, List<String> path, String current,
             String end, Map<String, Integer> distance,
             Map<String, List<String>> map) {
        path.add(current);
        if (current.equals(end)) {
            ladders.add(new ArrayList<String>(path));
        } else {
            for (String next : map.get(current)) {
                if (distance.containsKey(next) && distance.get(current) == distance.get(next) + 1) {
                    dfs(ladders, path, next, end, distance, map);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    void bfs(Map<String, List<String>> forwardGraph, Map<String, Integer> distance,
             String start, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            forwardGraph.put(s, new ArrayList<String>());
        }

        while (!q.isEmpty()) {
            String current = q.poll();

            List<String> neighbors = getAllNextLevelString(current, dict);
            for (String next : neighbors) {
                //构建图时，因为此时加入所有点，所以在dfs遍历图时需要判断走一步后是否缩短距离
                forwardGraph.get(next).add(current);
                if (!distance.containsKey(next)) { //最短距离
                    distance.put(next, distance.get(current) + 1);
                    q.offer(next);
                }
            }
        }
    }

    List<String> getAllNextLevelString(String vertex, Set<String> dict) {
        List<String> neighbors = new ArrayList<String>();

        for (int i = 0; i < vertex.length(); i++) {
            for (char possibleChar = 'a'; possibleChar <= 'z'; possibleChar++) {
                if (possibleChar != vertex.charAt(i)) {
                    String expanded = vertex.substring(0, i) + possibleChar
                            + vertex.substring(i + 1);
                    if (dict.contains(expanded)) {
                        neighbors.add(expanded);
                    }
                }
            }
        }

        return neighbors;
    }
}
