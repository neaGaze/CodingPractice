package solutions.bitmanipulation;

import java.util.ArrayList;

/**
 * Created by neaGaze on 10/15/18.
 */
public class FlipBitToWin {

    public FlipBitToWin() {}

    public FlipBitToWin(int val) {
        ArrayList<Integer> bitArr = new ArrayList<>();
        while(val >= 2) {
            bitArr.add(val % 2);
            val = val / 2;
        }
        bitArr.add(val);
        flip(bitArr);
    }

    // 11011101111 ans: 8
    // 11110111011

    // 110011
    public int flip(ArrayList<Integer> bitArr) {
        int onesFlag = 2, zerosFlag = 1;
        int firstPos, thirdCount = 0;
        int maxOne = 0, curCount = 1;
        for(int i = bitArr.size() - 1; i >= 0; i--) {
            firstPos = bitArr.size() - i;
            if(onesFlag < 0 && zerosFlag <= 0) {
                if(curCount > maxOne) maxOne = curCount;
                onesFlag = 1;
                zerosFlag = 1;
                curCount = thirdCount;;
            } else if(onesFlag >= 0) {
                if(onesFlag == 1 && zerosFlag > 0) {
                    zerosFlag -= (bitArr.get(firstPos) ^ bitArr.get(firstPos - 1));
                } else {
                    onesFlag -= (bitArr.get(firstPos) ^ bitArr.get(firstPos - 1));
                    thirdCount++; // will also include 0
                }
                curCount++;
            }

        }
        return maxOne;
    }

    /***
     * 10011101111 ans: 8
     *  ^
     * firstCounter = 0
     * secondCounter = 0
     * maxVal = 8
     * curCount = 8
     ***/
    public int flip(int val) {
        int maxval = 0, curCount = 0;
        int firstCounter = 0, secondCounter = 0;
        while(val > 0) {
            if((val & 1) == 1) {
                // the last bit is 1
                firstCounter++;
                if(secondCounter > 0)
                    curCount = firstCounter + secondCounter + 1;
            } else {
                // the last bit is 0
                if((val & 10) == 0)
                    secondCounter = 0;
                else secondCounter = firstCounter;

                firstCounter = 0;
            }

            if(curCount > maxval) maxval = curCount;
            val = val >>> 1;
        }
        System.out.println("The max length we can obtain by flipping 1 bit of " + val + " is: " + maxval);
        return maxval;
    }

    public static void test() {
        FlipBitToWin ab = new FlipBitToWin();
        ab.flip(1775);
        ab.flip(1775 & (1775 - 3));
    }
}
