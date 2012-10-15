package reilly.projectular.problems;

import java.util.Map;
import java.util.TreeMap;

/**
 * User: john
 * Date: 10/10/12
 * Time: 06:55
 */
public class Problem14 {
    static Map<Long,Integer> mp = new TreeMap<Long, Integer>();

    public static void main(String[] arg) {
        Problem14 problem14 = new Problem14();
		LongestChainData longestChainData = problem14.new LongestChainData();

		for(long i = 1; i < 1000000 ; i++) {
			int tempNumberOfTerms = problem14.calculateNumberTerms(i);
            mp.put(i, tempNumberOfTerms);
			if(tempNumberOfTerms > longestChainData.numberOfTerms) {
				longestChainData.numberOfTerms = tempNumberOfTerms;
				longestChainData.numberWithLongestChain = i;
			}
		}
		System.out.println("Number with largest number of terms = " + longestChainData.numberWithLongestChain);
		System.out.println("Number of terms it has = " + longestChainData.numberOfTerms);
    }

    private int calculateNumberTerms(long x) {
        int numberTerms = 0;
        while(true) {
            // base case
            if(x == 1) {
                numberTerms++;
                break;
            }
            if(mp.containsKey(x)) {
                numberTerms += mp.get(x);
                break;
            }
            numberTerms++;

            if(1 == (x & 1)) {
                x = (x * 3) + 1;
            } else {
                x = x / 2;
            }
        }
        return numberTerms;
    }

    private class LongestChainData {
        long numberWithLongestChain = 0;
        int numberOfTerms = 0;
    }
}