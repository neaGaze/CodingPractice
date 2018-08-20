package solutions.arrayandstring;

import java.net.URL;
import java.util.Arrays;

/*****
 * Created by neaGaze on 3/5/18.
 *
 *  Write a method to replace all spaces in a string with '%2e: You may assume that the string
 *  has sufficient space at the end to hold the additional characters, and that you are given the "true"
 *  length of the string. (Note: if implementing in Java, please use a character array so that you can
 *  perform this operation in place.)
 *
 ****/
public class URLify extends BaseClass {

    private String str;
    private char[] words = new char[128];
    private int actualWordSize;

    public URLify() {
    }

    public URLify(String word, int actualWordSize) {
        this.str = word;
        char[] newArr = word.toCharArray();
        for(int i = 0; i < newArr.length; i++)
            this.words[i] = newArr[i];

        this.actualWordSize = actualWordSize;
    }

    public String execute() {
        int spaces = 0;
        for (char word : words) {
            if(word == ' ') spaces++;
        }

        int c = actualWordSize - 1;
        int increment = 2 * spaces;
        while(c >= 0) {
            if(words[c] == ' ') {
                words[c + increment - 2] = '%';
                words[c + increment - 1] = '2';
                words[c + increment] = '0';
                increment = increment - 2;
            } else
                words[c + increment] = words[c];
            c--;

            if(increment == 1) break;
        }

        return Arrays.toString(words);
    }

    @Override
    public void test() {
        super.test();
        URLify test1 = new URLify("Mr John Smith", 13);
        System.out.println("The result of " + test1.getStr() + ": " + test1.execute());
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getActualWordSize() {
        return actualWordSize;
    }

    public void setActualWordSize(int actualWordSize) {
        this.actualWordSize = actualWordSize;
    }
}
