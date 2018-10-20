package solutions.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by neaGaze on 10/14/18.
 */
public class GroupAnagrams {

    public GroupAnagrams() {}

    public void sortAnagram(String[] arr) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(String word : arr) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedWord = new String(charArr);
            List<String> arrList = null;
            if(hmap.get(sortedWord) == null)
                arrList = new ArrayList<>();
            else
                arrList = hmap.get(sortedWord);
            arrList.add(word);
            hmap.put(sortedWord,  arrList);
        }

        int i = 0;
        for(List<String> valueList : hmap.values()) {
            int j = 0;
            while(valueList.size() > 0) {
                arr[i++] = valueList.get(j);
                valueList.remove(j);
            }
        }
    }


    static void print(String exp, String[] arr) {
        StringBuilder str = new StringBuilder();
        for(String a : arr)
            str.append(a+" ");
        System.out.println(exp);
        System.out.println(str.toString());
    }

    public static void test() {
        GroupAnagrams gr = new GroupAnagrams();
        String[] strArr = new String[] {"ab", "mam", "ba", "cat", "ta", "mma", "tac"};
        print("Before: \n", strArr);
        gr.sortAnagram(strArr);
        print("After: \n", strArr);
    }
}
