package reilly.projecteuler.problems.complete;

public class Problem12
{
    public static void main(String[] args) 
    {
        long startTime = System.currentTimeMillis();
        System.out.println("triangle 10 = " + triangle(7));
        System.out.println("Divisors 28 = " + numberDivisors(28));

        System.out.println("12/6 = " + 12/2);
        System.out.println("13/6 = " + 13/2);

        int maxNumberOfDivisors = 0;

        int currentTriangleNum = 0;
        for(int i = 1;i > 0; i++) {
            currentTriangleNum = i + currentTriangleNum;
            if (currentTriangleNum % 2 == 1) {
              //  System.out.println("prime triangle = " + currentTriangleNum);
                continue;
            }
            int numberDivisorsTria = numberDivisors(currentTriangleNum);
            if (numberDivisorsTria > maxNumberOfDivisors) {
                maxNumberOfDivisors = numberDivisorsTria;
            }
            if(numberDivisorsTria > 500) {
                System.out.println("500 = " + currentTriangleNum);
                System.out.println("total time = " + (System.currentTimeMillis() - startTime));
                System.exit(0);
            }
            System.out.println("current number = " + currentTriangleNum + "\t" + Integer.toString(currentTriangleNum).length());
            System.out.println("numberDivisorsTria = " + numberDivisorsTria + "\t" + "maxNumberOfDivisors = " + maxNumberOfDivisors);
        }

    }

    public static int triangle(int i) {
        if(i == 1) {
            return 1;
        }
        else 
            return(i + triangle(i - 1));
    }
    public static int numberDivisors(int i) {
        int total = 0;
        for(int x = 2; x <= Math.sqrt(i); x++){
            if(i % x == 0)
                total = total + 2;
        }
        return total + 2;
    }
//    public static int numberDivisors(int i) {
//        int total = 0;
//        for(int x = 2; x <= i/2; x++){
//            if(i % x == 0)
//                total++;
//        }
//        return total + 3;
//    } 

}
