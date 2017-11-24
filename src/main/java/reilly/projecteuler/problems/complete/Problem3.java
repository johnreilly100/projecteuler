package reilly.projecteuler.problems.complete;

/*
     *
     * The prime factors of 13195 are 5, 7, 13 and 29.
     * What is the largest prime factor of the number 600851475143 ?
     *
     */

import java.util.ArrayList;
import java.util.List;

class Problem3
{
    public static void main(String[] args) {

        List<Long> list = getPrimeFactors(600851475143L);
        System.out.println(list.get(list.size() - 1));
    }

    public static List<Long> getPrimeFactors(long i) {
        ArrayList<Long> primeList = new ArrayList<Long>();
        primeList.add((long) 2);
        primeList.add((long) 3);

        long startTime2 = System.currentTimeMillis();

        test:
        for(long x = 5; x < Math.sqrt(i); x = x + 2) {
            for (Long y : primeList) {
                if (x % y == 0) {
                    continue test;
                }
                if (y.intValue() >= Math.sqrt(x)) {
                    //  System.out.println("x = " + x + "y = " + y + " Math.sqrt(x) = " + Math.sqrt(x));
                    break;
                }
            }
            primeList.add(x);
        }
        long endTime2 = System.currentTimeMillis();
//        System.out.print("Total time = " + (endTime2 - startTime2));

        ArrayList<Long> primeFactors = new ArrayList<Long>();
        for(long prime: primeList) {
            if (i % prime == 0) {
                primeFactors.add(prime);
            }
        }

        return primeFactors;
    }
}
