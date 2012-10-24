package reilly.projecteuler.problems.inprogress;

import java.util.ArrayList;
import java.util.List;

/**
 * User: john
 * Date: 24/10/12
 * Time: 18:13
 */
public class Problem215 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem215 problem215 = new Problem215();

        int[] originRow = new int[33];
        for(int i = 0; i < 33; i++) {
            originRow[i] = 0;
        }
        originRow[0] = 1;
        originRow[32] = 1;

        ArrayList<int []> originRowHolder = new ArrayList<int []>();
        originRowHolder.add(originRow);

//        ArrayList<int []> rowConfigurations = problem215.calculateAllBlockLayoutsForOneRow(originRowHolder, 32);
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    ArrayList<int []> calculateAllBlockLayoutsForOneRow(ArrayList<int []> rowConfiguration, int rowSize) {



        for(int[] row: rowConfiguration) {
            if(row.length == rowSize)
            // add a block of two

            // add a block of three
        }
        List<Integer> rowLayout = new ArrayList<Integer>();

        return rowConfigurations;
    }
}
