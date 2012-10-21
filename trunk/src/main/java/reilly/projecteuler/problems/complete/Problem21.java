package reilly.projecteuler.problems.complete;

import java.util.ArrayList;

/**
 * User: john
 * Date: 21/10/12
 * Time: 19:39
 */
public class Problem21 {

    ArrayList<Integer> listOfAmicableNumbers = new ArrayList<Integer>();
    static int sumOfAllTheAmicableNumbersUnder10000 = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem21 problem21 = new Problem21();

        int[] sumOfProperDivisorsForTenThousand = new int[10000];
        for(int i = 2; i < 10000; i++) {
            sumOfProperDivisorsForTenThousand[i] = problem21.getSumOfProperDivisors(i);
        }
        for(int i = 2; i < 10000; i++) {
            int currentISum = sumOfProperDivisorsForTenThousand[i];
            if(currentISum < 2 || currentISum > 9999) {
                continue;
            }
            if(i == currentISum) {
                continue;
            }
            if(i == sumOfProperDivisorsForTenThousand[currentISum]) {
                System.out.println("i = " + i + " currentISum = " + currentISum);
                sumOfAllTheAmicableNumbersUnder10000 += i;
            }
        }
        System.out.println("Answer = " + sumOfAllTheAmicableNumbersUnder10000);
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    int getSumOfProperDivisors(int x) {
        return sumOfProperDivisors(calculateProperDivisors(x));
    }

    ArrayList<Integer> calculateProperDivisors(int x) {
        if(x < 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> listOfProperDivisors = new ArrayList<Integer>();
        listOfProperDivisors.add(1);
        for(int i = 2; i <= x / 2; i++) {
            if(x % i == 0) {
                listOfProperDivisors.add(i);
            }
        }
        return listOfProperDivisors;
    }

    int sumOfProperDivisors(ArrayList<Integer> listOfAmicableNumbers) {
        int total = 0;
        for(Integer in: listOfAmicableNumbers) {
            total += in;
        }
        return total;
    }
}
