package solutions.arrayandstring;

/**
 * Created by neaGaze on 3/5/18.
 */
public class Permutation extends BaseClass {
    private String firstStr, secondStr;

    public Permutation() {
    }

    public Permutation(String firstStr, String secondStr) {
        this.firstStr = firstStr;
        this.secondStr = secondStr;
    }

    public boolean execute() {

        Integer[] counter = new Integer[200];
        for (Integer index = 0; index < counter.length; index++)
            counter[index] = 0;

        for(char c : this.firstStr.toCharArray())
            counter[c]++;

        for(char c : this.secondStr.toCharArray())
            counter[c]--;

        for (Integer value : counter)
            if(value != 0) return false;

        return true;
    }

    @Override
    public void test() {
        Permutation permOfStr = new Permutation("ABA", "BAA");
        //boolean result = permOfStr.execute();
        System.out.println("result for " + permOfStr.getFirstStr() + " and " + permOfStr.getSecondStr() + ": " + permOfStr.execute());

        Permutation permOfStr2 = new Permutation("Helo", "gula");
        //boolean result = permOfStr.execute();
        System.out.println("result for " + permOfStr2.getFirstStr() + " and " + permOfStr2.getSecondStr() + ": " + permOfStr2.execute());

        Permutation permOfStr3 = new Permutation("", "");
        //boolean result = permOfStr.execute();
        System.out.println("result for " + permOfStr3.getFirstStr() + " and " + permOfStr3.getSecondStr() + ": " + permOfStr3.execute());

        Permutation permOfStr4 = new Permutation("2^3", "23^");
        //boolean result = permOfStr.execute();
        System.out.println("result for " + permOfStr4.getFirstStr() + " and " + permOfStr4.getSecondStr() + ": " + permOfStr4.execute());

    }

    public String getFirstStr() {
        return firstStr;
    }

    public void setFirstStr(String firstStr) {
        this.firstStr = firstStr;
    }

    public String getSecondStr() {
        return secondStr;
    }

    public void setSecondStr(String secondStr) {
        this.secondStr = secondStr;
    }
}
