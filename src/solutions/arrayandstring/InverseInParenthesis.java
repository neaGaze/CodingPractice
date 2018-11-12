package solutions.arrayandstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class InverseInParenthesis {
    /**
     * ou have a string s that consists of English letters, punctuation marks, whitespace characters, and brackets.
     * It is guaranteed that the parentheses in s form a regular bracket sequence.
     *
     * Your task is to reverse the strings contained in each pair of matching parentheses, starting from the
     * innermost pair. The results string should not contain any parentheses.
     *
     * Example
     *
     * For string s = “a(bc)de”, the output should be
     * reverseParentheses(s) = “acbde”.
     *
     * Input/Output
     *
     * [execution time limit] 4 seconds (py)
     *
     * [input] string s
     *
     * A string consisting of English letters, punctuation marks, whitespace characters and brackets.
     * It is guaranteed that parentheses form a regular bracket sequence.
     *
     * Constraints:
     * 5 ≤ s.length ≤ 55.
     *
     * [output] string
     *
     * Eg: a(b(cd)e) -> a(bdce) -> aecdb
     * Eg: a ( b ( c ( f g ) d  )  e  ) -> a(b(cgfd)e) -> a(bdfgce) -> aecgfdb
     *     0 1 2 3 4 5 6 7 8 9 10 11 12
     * output: a e c g f d b
     *
     * 1 : 12
     * 3 : 10
     * 5 : 8
     * 12 : 1
     * 10 : 3
     * 8 : 5
     *
     *  a   e   c   g f   d     b
     *  0 1 2 3 4 5 6 7 8 9 10 11 12
     * **/

    public String inverseInParenthesis(String str) {
        char[] charArr = str.toCharArray();
        int flipBit = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < charArr.length; i++) {
            char a = charArr[i];
            if(a == '(') {

            }
        }

        char[] newArr = new char[charArr.length];
        for(int i = 0; i < charArr.length; i++) {
            char a = charArr[i];
        }
        return "";
    }
}
