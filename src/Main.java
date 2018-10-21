import solutions.arrayandstring.*;
import solutions.bitmanipulation.*;
import solutions.linkedlist.*;
import solutions.recursion.RobotInAGrid;
import solutions.recursion.ThreeStep;
import solutions.sort.RadixSort;
import solutions.sort.*;
import solutions.stack.*;
import solutions.trees.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Intersection algo = new Intersection();
        //algo.test();
        //StackWithMin.test();
        RotatedArraySort.test();
    }

    public static boolean createRansomNote(String str) {
        HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
        for(Character c : str.toCharArray()) {
            if(c == ' ') continue;
            Integer value = hMap.get(c);
            if(value == null) hMap.put(c, 1);
            else hMap.put(c, value + 1);
        }
        boolean singleOdd = false;
        for(Character key : hMap.keySet()) {
            Integer val = hMap.get(key);
            if(val % 2 > 0) {
                if(singleOdd) return false;
                else singleOdd = true;
            }
        }
        return true;
    }
}
