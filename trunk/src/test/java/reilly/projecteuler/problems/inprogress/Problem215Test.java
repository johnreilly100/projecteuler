package reilly.projecteuler.problems.inprogress;

import org.junit.Test;

/**
 * User: john
 * Date: 24/01/13
 * Time: 20:18
 */
public class Problem215Test {

    @Test
    public void testAddTwoToRow() throws Exception {
        int widthOfWall = 9;
        int[] testRow = new int[widthOfWall];
        for(int i = 0; i < testRow.length; i++) {
            testRow[i] = -1;
        }
        Problem215 problem215 = new Problem215();
        problem215.addTwoToRow(testRow, widthOfWall);
//        assertEquals();
    }

}
