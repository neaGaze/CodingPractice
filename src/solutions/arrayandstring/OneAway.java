package solutions.arrayandstring;

/**
 * Created by neaGaze on 3/8/18.
 */
public class OneAway extends BaseClass {

    private String first, second;
    private char[] firstArr, secondArr;

    public OneAway() {}

    public OneAway(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public boolean execute() {
        int unmatchedLetters = 0, firstCounter = 0, secondCounter = 0;

        firstArr = first.toCharArray();
        secondArr = second.toCharArray();

        // iterative method
        /*
        while(firstCounter < firstArr.length && secondCounter < secondArr.length) {
            if(unmatchedLetters > 1) return false;

            if(firstArr[firstCounter] == secondArr[secondCounter]) {
                firstCounter++;
                secondCounter++;
            }

            if(firstArr[firstCounter] != secondArr[secondCounter]) {

                if(firstCounter == secondCounter) {
                    unmatchedLetters++;
                    secondCounter++;
                } else if(secondCounter - firstCounter == 1) {
                    secondCounter--;
                    firstCounter++;
                } else if(firstCounter - secondCounter == 1) {
                    secondCounter++;
                } else {
                    System.out.println("Unexpected result obtained");
                }
            }
        }
        */
        if(recursive(firstCounter, secondCounter) > 1) return false;
        return true;

    }

    private int recursive(int firstFlag, int secondFlag) {

        if(firstArr.length == firstFlag || secondArr.length == secondFlag)
            return Math.max((secondFlag - firstFlag), (firstFlag - secondFlag));

        if(secondFlag - firstFlag > 1) return secondFlag - firstFlag;

        if(firstFlag - secondFlag > 1) return firstFlag - secondFlag;

        if(firstArr[firstFlag] == secondArr[secondFlag]) {
            int val = recursive(firstFlag++, secondFlag++);
            System.out.println("[EQUAL] value when firstFlag: " + firstFlag + " and secondFlag: " + secondFlag + " => " + val);
            return val;
        }
        System.out.println("[UN-EQUAL] value when firstFlag: " + firstFlag + " and secondFlag: " + secondFlag);

        return Math.min(recursive(firstFlag++, secondFlag), recursive(firstFlag, secondFlag++));
    }

    @Override
    public void test() {
        super.test();
        OneAway test1 = new OneAway("pale", "ple");
        //test1.execute();
        System.out.println("The res of " + test1.getFirst() + " and " + test1.getSecond() + " is: " + test1.run());

        OneAway test2 = new OneAway("pales", "pale");
        System.out.println("The res of " + test2.getFirst() + " and " + test2.getSecond() + " is: " + test2.run());

        OneAway test3 = new OneAway("pale", "bale");
        System.out.println("The res of " + test3.getFirst() + " and " + test3.getSecond() + " is: " + test3.run());

        OneAway test4 = new OneAway("pale", "bake");
        System.out.println("The res of " + test4.getFirst() + " and " + test4.getSecond() + " is: " + test4.run());
    }


    public boolean run() {
        if((first.length() - second.length() > 1) || (second.length() - first.length() > 1)) return false;

        return checkForInsertOrRemove() || checkForReplace();
    }

    private boolean checkForInsertOrRemove() {
        int firstPtr = 0, secondPtr = 0;
        String bigger, smaller;
        if(first.length() >= second.length()) {
            bigger = first;
            smaller = second;
        } else {
            bigger = second;
            smaller = first;
        }
        //System.out.println("\t\tChecking insert or remove...");
        //int skipCnt = 0;
        int diff = 0;
        boolean isOneAway = true;
        for(int i = 0; i < smaller.length(); i++) {
            //System.out.println("firstPtr: " + firstPtr + ", secondPtr: " + secondPtr);
            if(bigger.charAt(firstPtr) == smaller.charAt(secondPtr)) {
                firstPtr++;
                secondPtr++;
            } else if(diff > 0) {
                isOneAway = false;
                break;
            } else {
                diff++;
                firstPtr++;
            }
        }

        if((diff == 0 && isOneAway) && bigger.length() - smaller.length() <= 1) isOneAway = true;
        return isOneAway;
    }

    private boolean checkForReplace() {
        int skipCnt = 0;
        int firstPtr = 0, secondPtr = 0;

        //System.out.println("\t\tChecking replace...");
        boolean isOneAway = true;
        for(int i = 0; i < first.length(); i++) {
            if(first.charAt(firstPtr++) == second.charAt(secondPtr++)) {

            } else if(skipCnt > 0) {
                isOneAway = false;
                break;
            } else {
                skipCnt++;
            }
        }
        return isOneAway;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
