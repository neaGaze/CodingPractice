package solutions.trees;

import java.util.*;

/**
 * Created by neaGaze on 10/1/18.
 */
public class NodeRoute {
    public HashMap<Integer, List<Integer>> adjList;

    public NodeRoute(){
        adjList = new HashMap<Integer, List<Integer>>();
    }

    public boolean findRoute(int s, int d) {
        if(adjList == null) return false;

        HashMap<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()) {
            Integer curKey = queue.poll();
            List<Integer> vals = adjList.get(curKey);
            if(vals == null) continue;
            visited.put(curKey, true);
            for(Integer i : vals) {
                queue.offer(i);
                if(d == i) return true;
            }
            System.out.println("Queue: " + queue.toString() + ", visited: " + visited.toString());
        }
        return false;
    }

    public void addToList(int s, int d) {
        if(adjList.containsKey(s)) adjList.get(s).add(d);
        else {
            List<Integer> list = new ArrayList<>();
            list.add(d);
            adjList.put(s, list);
        }
    }

    public void printAdjList() {
        for(Integer key : adjList.keySet()) {
            List<Integer> list = adjList.get(key);
            StringBuilder str = new StringBuilder(key+": ");
            for(Integer each : list) str.append(each + " ");
            System.out.println(str.toString());
        }
    }

    public static void test() {
        NodeRoute route = new NodeRoute();
        route.addToList(1, 2);
        route.addToList(2, 4);
        route.addToList(2, 5);
        route.addToList(3, 2);
        route.addToList(4, 7);
        route.addToList(4, 1);
        route.printAdjList();
        int s = 1, d = 7;
        boolean isFound = route.findRoute(s, d);
        System.out.println("The route between " + s +" and " + d + " is: " + isFound);
    }
}
