package reilly.projecteular.problems.oldanddonotwork;

public class Problem7 {

    static int counter = 2;
    static double answer = 0;

    public static void main(String[] args) {
    
        for (double i = 4;; i++) {
            for (double j = i - 1; j > 1; j--) {
               // System.out.println("temp = " +i%j);
                if (i % j == 0) {
                      //System.out.println("Inside mode I = " +i +"J = " +j);
                     // System.out.println("remainder = " +i%j);
                    break;
                }
                if ( j == 2) {
                   // System.out.println("I = " +i +"J = " +j);
                    counter++;
                    answer = i;
                   // System.out.println("I = " +i);
                }
            }
            if (counter == 1000) {
                System.out.println("Counter = " +counter);
                System.out.println("Answer = " +answer);
                System.exit(0);
            }
        }
    }
}
