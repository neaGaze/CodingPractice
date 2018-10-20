package solutions.bitmanipulation;

import java.util.Arrays;

/**
 * Created by neaGaze on 10/9/18.
 */
public class BinToString {

    public BinToString(double dblValue) {
        print(dblValue, convert(dblValue));
    }

    public String convert(double dblValue) {
        int[] binary = new int[32];
        int i = 0;
        while(i < 32 && dblValue > 0) {
            double twice = dblValue * 2;
            binary[i] = (int) Math.floor(twice);
            if(binary[i] == 1)
                dblValue = twice - 1;
            else
                dblValue = twice;
            System.out.println("i: " + i + ", and dblValue: " + dblValue);
            i++;
        }
        if(i == 32) System.out.println("ERROR. Can't be represented in 32 bytes");
        return Arrays.toString(binary);
    }

    public void print(double abc, String binary) {
        System.out.println("The binary equivalent of :" + abc + " is: " + binary);
    }

    public static void test() {
        BinToString a1 = new BinToString(0.625);
    }
}
