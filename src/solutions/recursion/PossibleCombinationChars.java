package solutions.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given two parameters:
 * 1) A mapping from digits (represented as strings or chars) to a list of letters.
 *
 * mapping = {'1': ['A', 'B', 'C'], '2': ['D', 'E', 'F'], '3': ['G', 'H', 'I'], '4': ['J', 'K', 'L'] ...}
 *
 *
 * 2) A number represented as a string such as '12'
 *
 * You want to return all the possible ways to replace each digit in the input string with its respective letters from the mapping.
 *
 * Example
 * '12' with the list above will return => [AD, AE, AF, BD, BE, BF, CD, CE, CF]
 ***/
public class PossibleCombinationChars {
    /*
     * Complete the phoneNumberToString function below. You can edit the function signature if necessary.
     */
    // 12
    //          root
    //     A      B     C
    //   D E F  D E F  D E F
    static void phoneNumberToString(String digits, HashMap<Character, char[]> mapping) {
        List<String> result = new ArrayList<String>();
        recurse(digits.toCharArray(), mapping, "", result);
        result.forEach(str -> System.out.println(str));
    }

    public static void recurse(char[] digitArr, HashMap<Character, char[]> mapping, String prefix, List<String> result) {

        if(digitArr.length == 0) {
            result.add(prefix);
            return;
        }

        for(char each : mapping.get(digitArr[0])) {
            String newStr = prefix + each;
            char[] charArr = new char[digitArr.length - 1];
            for(int j = 1; j < digitArr.length; j++)
                charArr[j - 1] = digitArr[j];
            recurse(charArr, mapping, newStr, result);
        }
    }

    public static void test() {
        PossibleCombinationChars a = new PossibleCombinationChars();
        HashMap<Character, char[]> myMap = new HashMap<Character, char[]>();
        myMap.put('1', "ABC".toCharArray());
        myMap.put('2', "DEF".toCharArray());
        myMap.put('3', "GHI".toCharArray());
        myMap.put('4', "JKL".toCharArray());
        a.phoneNumberToString("12", myMap);
    }
}
