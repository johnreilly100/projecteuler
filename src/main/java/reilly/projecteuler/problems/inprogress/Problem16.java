package reilly.projecteuler.problems.inprogress;

import java.math.BigDecimal;

import static java.lang.Math.pow;

/**
 * Created by IntelliJ IDEA.
 * User: rjohn
 * Date: 18-Oct-2012
 * Time: 09:02:51
 * To change this template use File | Settings | File Templates.
 */
public class Problem16 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        //problem is to convert 2^1000 from binary into decimal
        // binary answer is 1 with 1000 zeros after it.
        double temp = pow(2, 700);
//        BigInteger result = BigInteger.valueOf(pow(2, 1000));
        BigDecimal bd = new BigDecimal(pow(2, 500));
        bd.
        Integer.parseInt("10000", 2);

        System.out.println("result = " + bd);
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }
}
