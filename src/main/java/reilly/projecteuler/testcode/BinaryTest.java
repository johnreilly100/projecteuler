package reilly.projecteuler.testcode;

/**
 * User: john
 * Date: 26/01/13
 * Time: 15:11
 */
public class BinaryTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int anInt1 = 0b101;
        int anInt2 = 0b101;
        int anInt3 = 0b010;
        int answer = anInt1 & anInt3;
        System.out.println("Answer = " + answer);
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }
}
