package solutions.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by neaGaze on 10/16/18.
 *
 *
 */
public class WildCardSearch {

    private Node root;

    public WildCardSearch() {
        root = new Node();
    }

    public WildCardSearch(ArrayList<String> arr) {
        root = new Node();
        preprocess(arr);
    }

    class Node {
        Character val;
        boolean isEnd;
        HashMap<Character, Node> charMap;

        public Node() {
            isEnd = true;
            charMap = new HashMap<>();
        }

        public Node(Character val) {
            this.val = val;
            isEnd = false;
            charMap = new HashMap<>();
        }

        public void addNode(Character val) {
            Node newNode = new Node(val);
            this.charMap.put(val, newNode);
        }
    }


    /**
     * Time Complexity: O(arr.length() * longest_word_in_arr)
     * Space Complexity: O(longest_word_in_arr * arr.length())
     ****/
    public void preprocess(ArrayList<String> arr) {
        Node travelingNode;
        System.out.println("** Preprocessing **");
        for(String word : arr) { // foo
            travelingNode = root; // nil
            StringBuilder b = new StringBuilder();
            for(int i = 0; i < word.length(); i++) { // i = b
                Character a = word.charAt(i);   // a =  b
                Node existingNode = travelingNode.charMap.get(a); // existingNode = null

                if(existingNode == null) {
                    travelingNode.addNode(a); // (nil, true, [(f, false, [(o, false, [(o, true, null)])]), (b, false, null)])
                    existingNode = travelingNode.charMap.get(a);
                }
                travelingNode = existingNode; // travelingNode = (o, true, null)
                if(i == word.length() - 1) travelingNode.isEnd = true; // cond = true, (0, true, null)
                b.append("(").append(existingNode.val).append(", ").append(existingNode.isEnd).append(")").append(" -> ");
            }
            b.append("null");
            System.out.println(b.toString());
        }
    }

    /**
     * arrList : { foo, bar, fao }
     * wildCard: f*o
     *
     * f -> | o -> o | a -> o |
     * b -> | a -> r | * ->
     *
     *
     /*********************************************************
     * Time Complexity: O(word.length * count_of_asterisks)
     * Space Complexity: O(longest_word_in_arr * arr.length())
     ***********************************************************/
    public boolean searchWords(String wildCard, int charPos, Node curNode, boolean shouldSearch) {
            if(!shouldSearch) return shouldSearch;

            if(curNode == null) return false;

            if(charPos >= wildCard.length())
                return curNode.isEnd;

            Character ch = wildCard.charAt(charPos);
            Node curChild = curNode.charMap.get(ch);

            if(curChild == null) {
                if(ch == '*' && curNode.charMap.size() == 0) {
                    if(wildCard.length() - charPos - 1 == 0) return true;
                    return false;
                } else if(ch == '*') {
                    boolean res = true;
                    for(Character children : curNode.charMap.keySet()) {
                        res = searchWords(wildCard, charPos + 1, curNode.charMap.get(children), true);
                        if(res) return res;
                    }
                    return res;
                } else return false;
            }
            boolean res =  searchWords(wildCard, charPos+1, curChild, true);
            System.out.println("Looking up " + wildCard.charAt(charPos)+" at " + curChild.val +": " + res);
            return res;
    }

    public boolean find(String wildcard) {
        return searchWords(wildcard, 0, root, true);
    }

    public static void test() {
        ArrayList<String> tries = new ArrayList<>();
        tries.add("foo");
        tries.add("boo");
        tries.add("fam");
        tries.add("fart");
        tries.add("food");
        WildCardSearch abc = new WildCardSearch(tries);
        String word = "foo";
        System.out.println("\n=====Searching for the word: " + word + "======");
        System.out.println("The "+ word + " is " + abc.find(word));
        String word2 = "foode";
        System.out.println("\n=====Searching for the word: " + word2 + "======");
        System.out.println("The "+ word2 + " is " + abc.find(word2));
        String word3 = "far";
        System.out.println("\n=====Searching for the word: " + word3 + "======");
        System.out.println("The "+ word3 + " is " + abc.find(word3));
        String word4 = "f*o";
        System.out.println("\n=====Searching for the word: " + word4 + "======");
        System.out.println("The "+ word4 + " is " + abc.find(word4));
        String word5 = "*a*t";
        System.out.println("\n=====Searching for the word: " + word5 + "======");
        System.out.println("The "+ word5 + " is " + abc.find(word5));
        String word6 = "d*o";
        System.out.println("\n=====Searching for the word: " + word6 + "======");
        System.out.println("The "+ word6 + " is " + abc.find(word6));
        String word7 = "******";
        System.out.println("\n=====Searching for the word: " + word7 + "======");
        System.out.println("The "+ word7 + " is " + abc.find(word7));
        String word8 = "boohmandu";
        System.out.println("\n=====Searching for the word: " + word8 + "======");
        System.out.println("The "+ word8 + " is " + abc.find(word8));
        String word9 = "**";
        System.out.println("\n=====Searching for the word: " + word9 + "======");
        System.out.println("The "+ word9 + " is " + abc.find(word9));
    }
}
