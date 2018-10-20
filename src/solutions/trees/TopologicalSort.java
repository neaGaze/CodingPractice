package solutions.trees;

import java.util.*;

/**
 * Created by neaGaze on 10/7/18.
 */
public class TopologicalSort {
    int size;
    HashMap<String, LinkedList<String>> adjMap;

    public TopologicalSort(int size) {
        this.size = size;
        this.adjMap = new HashMap<String, LinkedList<String>>();
    }

    public void add(String a, String b) {
        if(adjMap.get(a) == null) adjMap.put(a, new LinkedList<>());
        adjMap.get(a).add(b);
    }

    public void sort() {
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        Stack stack = new Stack();
        for(String key : adjMap.keySet())
            dfs(key, visited, stack);

        while(!stack.isEmpty()) System.out.println(stack.pop());
    }

    public void dfs(String key, HashMap<String, Boolean> visited, Stack stack) {
        if(visited.get(key) != null && visited.get(key).booleanValue()) return;

        visited.put(key, true);
        LinkedList<String> list = adjMap.get(key);
        if(list == null)
            list = new LinkedList<>();

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
                String val = iter.next();
                System.out.println("Currently visiting node: " + key + " with addList: " + adjMap.toString() + " and stack: " + stack.toString());
                System.out.println("val: " + val + ", visited: " + visited.toString());
                if (visited.get(val) == null || (visited.get(val) != null && !visited.get(val).booleanValue())) {
                    System.out.println("recursively calling " + val +" from " + key);
                    dfs(val, visited, stack);
                }
                System.out.println("");
        }
        stack.push(key);
    }

    public static void test() {
        TopologicalSort topo = new TopologicalSort(8);
        topo.add("f", "c");
        topo.add("f", "a");
        topo.add("f", "b");
        topo.add("c", "a");
        topo.add("b", "a");
        topo.add("a", "e");
        topo.add("b", "e");
        topo.add("b", "h");
        topo.add("d", "g");
        topo.sort();
    }
}
