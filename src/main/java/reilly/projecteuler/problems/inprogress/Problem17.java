package reilly.projecteuler.problems.inprogress;

/**
 * Created by IntelliJ IDEA.
 * User: rjohn
 * Date: 16/10/12
 * Time: 09:54
 * To change this template use File | Settings | File Templates.
 */
public class Problem17 {
    static final int AND = 3;
    static final int HUNDRED = 7;
    static final int THOUSAND = 8;
    static final int[] ONE_TWO_TWENTY = {0, 3, 3, 5, 4, 4 ,3, 5, 5, 4, 3,
            6, 6, 8, 8, 7, 7, 9, 8, 8, 6};
    static final int[] TWENTY_TWO_NINETY_IN_TENS = {0, 0, 6, 6, 5, 5, 5, 7, 6, 6};

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem17 problem17 = new Problem17();
        System.out.println("Total letters =  " + problem17.computeLettersInNumber(1, 1000));
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    int computeLettersInNumber(int x, int y) {
        int totalLetters = 0;
        for(int i = x; i <= y ; i++) {
             if(i > 0 && i < 100) {
                totalLetters += oneTwoNinetyNine(i);
             } else if(i == 100) {
                totalLetters += oneTwoTwenty(1);
                totalLetters += HUNDRED;
             } else if(i > 100 && i <= 999) {
                totalLetters += oneTwoTwenty(extractOutCertainDigitFromNumber(i,0));
                totalLetters += HUNDRED;
                totalLetters += AND;
                int secondDigit = extractOutCertainDigitFromNumber(i,1);
                if(secondDigit == 0) {
                    totalLetters += oneTwoTwenty(extractOutCertainDigitFromNumber(i,2));
                } else {
                    totalLetters += oneTwoNinetyNine((secondDigit * 10) + extractOutCertainDigitFromNumber(i,2));
//                    totalLetters += TwentyoneTwoNinetynine(extractOutCertainDigitFromNumber(i,1));
//                    totalLetters += oneTwoTwenty(extractOutCertainDigitFromNumber(i,2));
                }
            } else if(x == 1000) {
                totalLetters += oneTwoTwenty(1);
                totalLetters += THOUSAND;
            }
        }
        return totalLetters;
    }

    int oneTwoNinetyNine(int x) {
        int total = 0;
        if(x > 0 && x <= 20) {
            return oneTwoTwenty(x);
        } else if(x > 20 && x <= 99) {
            total += oneTwoTwenty(extractOutCertainDigitFromNumber(x,1));
            total += TwentyoneTwoNinetynine(extractOutCertainDigitFromNumber(x,0));
        }
        return total;
    }
    
    int oneTwoTwenty(int x) {
        if(x < 0 || x > 20) {
            throw new IllegalArgumentException();
        }
        return ONE_TWO_TWENTY[x];
    }

    int TwentyoneTwoNinetynine(int x) {
        if(x < 2 || x > 9) {
            throw new IllegalArgumentException();
        }
        return TWENTY_TWO_NINETY_IN_TENS[x];
    }

    int OneHundredTwoNineHundredAndNinetynine(int x) {
        if(x < 2 || x > 9) {
            throw new IllegalArgumentException();
        }
        return TWENTY_TWO_NINETY_IN_TENS[x];
    }

    int extractOutCertainDigitFromNumber(int numberToParse, int digitRequired) {
//        if(numberToParse < digitRequired.) {
//            throw new IllegalArgumentException();
//        }
        String number = String.valueOf(numberToParse);
        int temp = Character.getNumericValue(number.charAt(digitRequired));
//        System.out.println("Temp " + temp);
        return temp;
    }
}
