package reilly.projecteuler.problems.complete;

import java.util.*;
import java.util.List;

/**
 * User: john
 * Date: 10/10/12
 * Time: 06:55
 * Note: This problem is a simpler version of problem 63
 *
 */
public class Problem18 {

    public static void main(String[] arg) {
        Problem18 problem18 = new Problem18();
        problem18.maximumTotalFromTopToBottom();
    }

    void maximumTotalFromTopToBottom() {
        List<int[]> rowList = new ArrayList<int[]>();

        // Problem 18 numbers.
        rowList.add(new int[]{75});
        rowList.add(new int[]{95 ,64});
        rowList.add(new int[]{17 ,47 ,82});
        rowList.add(new int[]{18 ,35 ,87 ,10});
        rowList.add(new int[]{20 ,4 ,82 ,47 ,65});
        rowList.add(new int[]{19 ,1 ,23 ,75 ,3 ,34});
        rowList.add(new int[]{88 ,2 ,77 ,73 ,7 ,63 ,67});
        rowList.add(new int[]{99 ,65 ,4 ,28 ,6 ,16 ,70 ,92});
        rowList.add(new int[]{41 ,41 ,26 ,56 ,83 ,40 ,80 ,70 ,33});
        rowList.add(new int[]{41 ,48 ,72 ,33 ,47 ,32 ,37 ,16 ,94 ,29});
        rowList.add(new int[]{53 ,71 ,44 ,65 ,25 ,43 ,91 ,52 ,97 ,51 ,14});
        rowList.add(new int[]{70 ,11 ,33 ,28 ,77 ,73 ,17 ,78 ,39 ,68 ,17 ,57});
        rowList.add(new int[]{91 ,71 ,52 ,38 ,17 ,14 ,91 ,43 ,58 ,50 ,27 ,29 ,48});
        rowList.add(new int[]{63 ,66 ,4 ,68 ,89 ,53 ,67 ,30 ,73 ,16 ,69 ,87 ,40 ,31});
        rowList.add(new int[]{4 ,62 ,98 ,27 ,23 ,9 ,70 ,98 ,73 ,93 ,38 ,53 ,60 ,4 ,23});

        // start at the second last row and work up to the top row.
        for(int i = rowList.size() - 2; i > -1; i--) {
            int[] topRow = rowList.get(i);
            int[] bottomRow = rowList.get(i + 1);

            // for each element on the top row add the max of the two elements below to its value
            for(int x = 0; x < topRow.length; x++) {
                if(bottomRow[x] > bottomRow[x + 1]) {
                    topRow[x] = topRow[x] + bottomRow[x];
                } else {
                    topRow[x] = topRow[x] + bottomRow[x + 1];
                }
            }
            // save the top rows new values
            rowList.set(i, topRow);
        }
        System.out.println("maximum total from top to bottom = " + rowList.get(0)[0]);
    }
}