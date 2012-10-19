package reilly.projecteuler.problems.complete;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: rjohn
 * Date: 18-Oct-2012
 * Time: 09:02:51
 * To change this template use File | Settings | File Templates.
 */
public class Problem20 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem20 problem20 = new Problem20();
        BigInteger result = problem20.calculateFactorial(new BigInteger("100"));
        String resultAsString = result.toString();

        System.out.println("result = " + resultAsString);
        char[] charArray = resultAsString.toCharArray();
        int total =0;
        for(char c: charArray) {
            total += Character.getNumericValue(c);
        }
         System.out.println("total = " + total);
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    public BigInteger calculateFactorial(BigInteger i) {
        if(i.compareTo(new BigInteger("0")) == -1) {
            throw new IllegalArgumentException();
        }
        if(i.compareTo(new BigInteger("1")) == 0) {
            return new BigInteger("1");
        } else {
            return i.multiply(calculateFactorial(new BigInteger(i.subtract(new BigInteger("1")).toString())));
        }
    }
}
