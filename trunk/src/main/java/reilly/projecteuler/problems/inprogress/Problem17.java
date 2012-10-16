package reilly.projecteuler.problems.inprogress;

/**
 * Created by IntelliJ IDEA.
 * User: rjohn
 * Date: 16/10/12
 * Time: 09:54
 * To change this template use File | Settings | File Templates.
 */
public class Problem17 {

    static final int[] ONE_TWO_TWENTY = {0, 3, 3, 5, 4, 4 ,3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8, 6};
    static final int[] TWENTYONE_TWO_NINETYNINE = { };

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem17 problem17 = new Problem17();
        System.out.println("Total letters =  " + problem17.computeLettersInNumber(1, 5));
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    int computeLettersInNumber(int x, int y) {
        int totalLetters = 0;
        for(int i = x; i <= y ; i++) {
            if(i > 0 || i < 21) {
                totalLetters += oneTwoTwenty(i);
            }
        }
        return totalLetters;
    }
    
    int oneTwoTwenty(int x) {
        if(x < 1 || x > 20) {
            throw new IllegalArgumentException();
        }
        return ONE_TWO_TWENTY[x];
    }

    int TwentyoneTwoNinetynine(int x) {
        if(x < 21 || x > 99) {
            throw new IllegalArgumentException();
        }
        return TWENTYONE_TWO_NINETYNINE[x];
    }
}
