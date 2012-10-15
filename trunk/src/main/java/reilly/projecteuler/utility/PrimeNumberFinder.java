package reilly.projecteuler.utility;

import java.util.ArrayList;
import java.lang.Math;

public class PrimeNumberFinder {

    static int counter = 2;
    static double answer = 0;
    static long startTime = 0;
    static long endTime = 0;

    public static void main(String[] args) {

        startTime = System.currentTimeMillis();

        primeNumUpto(1);
        System.exit(0);


        for (double i = 5;; i = i + 2) {
            int temp = (int)i / 2;
           // System.out.println("temp = " +temp);
          //  for (double j = temp; j > 1; j--) {
       /*     for (double j = 3; j < temp; j = j + 2) {
               // System.out.println("temp = " +i%j);
                if (i % j == 0) {
                      //System.out.println("Inside mode I = " +i +"J = " +j);
                     // System.out.println("remainder = " +i%j);
                    break;
                }
                if (j == temp - 1) {
                    System.out.println("I = " +i +"J = " +j);
                    counter++;
                    answer = i;
                   // System.out.println("I = " +i);
                }
            }   */
            double j = 3;
            while (j < temp) {
                if (i % j == 0) {
                      //System.out.println("Inside mode I = " +i +"J = " +j);
                     // System.out.println("remainder = " +i%j);
                    break;
                }
                j = j + 2;
            }
            System.out.println("I = " +i +"J = " +j);
            counter++;
            answer = i;
            if (counter == 1000) {
                System.out.println("Counter = " +counter);
                System.out.println("Answer = " +answer);

                endTime = System.currentTimeMillis();
                long timeTaken = (endTime - startTime);// / 1000;
                System.out.println("Time taken = " +timeTaken);
                System.exit(0);
            }
        }
    }

    public static void primeNumUpto(int i) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        primeList.add(2);
        primeList.add(3);
        int counter = 0;
        
        long startTime2 = System.currentTimeMillis();

        test:
        for(int x = 5; x < 1000000000; x = x + 2) {
            for (Integer y : primeList) {
                if (x % y == 0) {
                    continue test;
                }
                if (y.intValue() >= Math.sqrt(x)) {
                  //  System.out.println("x = " + x + "y = " + y + " Math.sqrt(x) = " + Math.sqrt(x));
                    break;
                }
            }
            primeList.add(x);
            System.out.print(x + "\t" + primeList.size() + "\t" + ((System.currentTimeMillis() - startTime) / 1000) + "\t" + Integer.toString(x).length() + "\t");
            counter++;
            if (counter % 5 == 0){
                System.out.println("");
            }
        }
        long endTime2 = System.currentTimeMillis();
        System.out.print("Total time = " + (endTime2 - startTime2));
    }
}
