package solutions.arrayandstring;

/**
 * Created by neaGaze on 3/6/18.
 */
public class PalindromePermutation extends BaseClass {

    private String str;
    private int[] count;

    public PalindromePermutation() {
    }

    public PalindromePermutation(String str) {
        this.str = str;
        count = new int[str.length()];
    }


    /**
     * For conversion from caps to small -> `letter` ^ 0x20
     * For conversion from small to caps -> `letter` ^ 0x5f
     *
     * ref: https://stackoverflow.com/questions/3696441/converting-a-char-to-uppercase
     * **/
    private int getAscii(char letter) {
        if(letter >= 'A' && letter <= 'Z')
            return (letter ^ 0x20) - 'a' + 1;

        if(letter < 'a' || letter > 'z') return -1;

        return letter - 'a' + 1;
    }

    public boolean execute() {
        int curCount = 0;
        for(int i = 0; i < str.length(); i++) {
            int res = getAscii(str.charAt(i));

            if(res < 0) continue;

            System.out.println("char at "+ i + ": " + res);
            curCount ^= (1 << res);
        }

        System.out.println("curCount: " + curCount);
        if(curCount == 0) return true;

        int countMinus = curCount - 1;
        if((countMinus & curCount) == 0) return true;
        return false;
    }

    @Override
    public void test() {
        super.test();
        PalindromePermutation test1 = new PalindromePermutation("tact coa");
        System.out.println("The result of " + test1.getStr() + " is: " + test1.execute() + "\n");

        PalindromePermutation test2 = new PalindromePermutation("tact b");
        System.out.println("The result of " + test2.getStr() + " is: " + test2.execute() + "\n");

        PalindromePermutation test3 = new PalindromePermutation("Tact coA");
        System.out.println("The result of " + test3.getStr() + " is: " + test3.execute() + "\n");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    public boolean palindromeRearranging(String inputString) {
        int finalVal = 0;
        for(char c : inputString.toCharArray()) {
            int intValue = c - 'a';
            finalVal = finalVal ^ (1 << intValue);
        }
        if(finalVal == 0 || ((finalVal - 1 & finalVal) == 0)) return true;
        return false;
    }

}
