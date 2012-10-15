package reilly.projecteuler.problems.complete;

/**
 * User: john
 * Date: 15/10/12
 * Time: 21:51
 * Note: brute force solution, just checks every multiple of 20
 */
public class Problem5 {
    static int answer=20;
    static int[] numbers = new int[]
            {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    public static void main(String[] args){
        System.out.println(worker() );
    }

    public static int worker(){
        while (true) {
            for(int x: numbers) {
                if ( (answer % x) != 0 ) {
                    break;
                }
                if (x == 20) {
                    return answer;
                }
            }
            answer+=20;
        }
    }
}
