package solutions.graph;

import java.util.*;

public class MeshMessage {

    /**
     * Time Complexity : O(N + M)
     * Space Complexity : O(N)
     * **/
    public List<String> shortestRoute(Map<String, String[]> network, String src, String dest) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add(src);
        Node node = new Node(1, src, arrList);
        queue.offer(node);
        Map<String, Node> hmap = new HashMap<String, Node>();
        bfs(network, dest, queue, hmap);
        System.out.println("The shortest dist: " + hmap.get(dest).hop);
        System.out.println("The shortest path: ");
        for(String a : hmap.get(dest).route)
            System.out.println(a);
        return hmap.get(dest).route;
    }

    /*
    * A -> B, C
    * B -> D, A
    * C -> E
    * D -> E
    *
    * A(1)              -> {}
    * B(2), C(2)        -> {(A1)}
    * C(2), D(3), A(3)  -> {(A1), (B2)}
    * D(3), A(3), E(3)  -> {(A1), (B2), (C2)}
    * A(3), E(3), E(4)  -> {(A1), (B2), (C2), (D3)}
    * E(3), E(4)        -> {(A1), (B2), (C2), (D3)}
    * E(4)              -> {(A1), (B2), (C2), (D3), (E3)}
    * X                 -> {(A1), (B2), (C2), (D3), (E3)}
    *
    ***/
    public void bfs(Map<String, String[]> network, String dest, Queue<Node> queue, Map<String, Node> hmap) {
        while(! queue.isEmpty()) {
            Node node = queue.poll();
            if(!hmap.containsKey(node.name) || (hmap.get(node.name).hop > node.hop)) {
                hmap.put(node.name, node);

                // System.out.println("" + node.name + ", len: " + queue.toString());
                if (!node.name.equals(dest)) {
                    for (String route : network.get(node.name)) {
                        ArrayList<String> list = new ArrayList<>();//node.route;
                        for (String n : node.route)
                            list.add(n);
                        list.add(route);
                        Node newNode = new Node(list.size(), route, list);
                        queue.offer(newNode);
                    }
                }
            }
        }
    }

    public class Node {
        int hop;
        String name;
        ArrayList<String> route;
        public Node(int hop, String name, ArrayList<String> route) {
            this.hop = hop;
            this.name = name;
            this.route = route;
        }

        public void addRoute(String name) {
            if(route == null) route = new ArrayList<String>();
            route.add(name);
        }

        @Override
        public String toString() {
            return "("+name+", "+hop+")";
        }
    }

    public static void test() {
        Map<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min",     new String[] { "William", "Jayden", "Omar" });
            put("William", new String[] { "Min", "Noam" });
            put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
            put("Ren",     new String[] { "Jayden", "Omar" });
            put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
            put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
            put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
            put("Noam",    new String[] { "Nathan", "Jayden", "William" });
            put("Omar",    new String[] { "Ren", "Min", "Scott" });
            put("Nathan", new String[] {});
            put("Scott", new String[] {});
            put("Liam", new String[] {});
        }};
        new MeshMessage().shortestRoute(network, "Jayden", "Adam");

        Map<String, String[]> network2 = new HashMap<String, String[]>() {{
            put("A", new String[] { "B", "C"});
            put("B", new String[] { "D", "A" });
            put("C", new String[] { "E"});
            put("D", new String[] { "E" });
        }};
        new MeshMessage().shortestRoute(network2, "A", "E");


        Map<String, String[]> network3 = new HashMap<String, String[]>() {{
            put("A", new String[] { "B", "C"});
            put("B", new String[] { "D", "A" });
            put("C", new String[] { "E"});
        }};
        new MeshMessage().shortestRoute(network3, "A", "A");
    }
}
