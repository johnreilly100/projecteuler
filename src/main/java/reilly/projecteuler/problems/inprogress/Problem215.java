package reilly.projecteuler.problems.inprogress;

import java.util.ArrayList;

/**
 * User: john
 * Date: 24/10/12
 * Time: 18:13
 */
public class Problem215 {
    
    static int total = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem215 problem215 = new Problem215();
        problem215.runProgram();
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    private void runProgram() {
        int widthOfWall = 9;
        int heightOfWall = 3;
        int[] testRow = new int[widthOfWall];
        System.out.println("testRow.length = " + testRow.length);
        for(int i = 0; i < testRow.length; i++) {
            testRow[i] = -1;
        }
        ArrayList<int []> rowConfigurations = new ArrayList<int[]>();
        calculateAllLayoutsForOneRow(testRow, widthOfWall, rowConfigurations);
        System.out.println("rowConfigurations size = " + rowConfigurations.size());
        int x = 0;
        for(int[] row: rowConfigurations) {
            printArray(row);
            x++;
            if(x == 100) {
                break;
            }
        }
        calculateNumberOfWaysOfFormingWall(rowConfigurations, heightOfWall);
        System.out.println("Total ways = " + total);
    }

    private int calculateNumberOfWaysOfFormingWall(ArrayList<int []> layoutsForOneRow, int numberOfRows) {
//        int total = 0;
        for(int [] row: layoutsForOneRow) {
//            System.out.println("First level row");
            checkIfOtherRowsCanBeStacked(row, layoutsForOneRow, numberOfRows - 1);
        }
        return total;
    }

    private void checkIfOtherRowsCanBeStacked(int [] previousRow, ArrayList<int []> layoutsForOneRow, int numberOfRows) {
//        System.out.println("numberOfRows = " + numberOfRows);
        for(int [] row: layoutsForOneRow) {
            boolean result = checkCanTwoRowsBeStackedOnTopOfEachOther(previousRow, row);
            if(result) {
                if(numberOfRows == 1) {
                    System.out.println("Complete row");
//                    printArray(previousRow);
//                    printArray(row);
//                    System.out.println("");
                    total++;
                } else {
                    System.out.println("not at top yet numberOfRows = " + numberOfRows);
                    checkIfOtherRowsCanBeStacked(row, layoutsForOneRow, --numberOfRows);
                }
            }
        }
    }

    private boolean checkCanTwoRowsBeStackedOnTopOfEachOther(int[] row1, int[] row2) {
        for(int i = 2; i < row1.length; i++) {
            if(row1[i] == 1 && row2[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(i == array.length -1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i]);
            }
        }
    }
    
    private int[] copyArray(int[] source) {
        int[] destination = new int[source.length];
        System.arraycopy(source, 0, destination,0 , source.length);
        return destination;
    }

    private void calculateAllLayoutsForOneRow(int[] row, int rowLength, ArrayList<int []> rowConfigurations) {
        int[] firstCopy = copyArray(row);
        if(addTwoToRow(firstCopy, rowLength)) {
            if(checkIfRowIsFull(firstCopy, rowLength)) {
                rowConfigurations.add(firstCopy);    
            } else {
                calculateAllLayoutsForOneRow(firstCopy, rowLength, rowConfigurations);
            }
        }
        int[] secondCopy = copyArray(row);
        if(addThreeToRow(secondCopy, rowLength)) {
            if(checkIfRowIsFull(secondCopy, rowLength)) {
                rowConfigurations.add(secondCopy);
            } else {
                calculateAllLayoutsForOneRow(secondCopy, rowLength, rowConfigurations);
            }
        }
    }

    private boolean checkIfRowIsFull(int[] row, int rowLength) {
        if(row[rowLength - 1] != -1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean addTwoToRow(int[] row, int rowLength) {
        int nextFreeIndex = calculateNexFreeIndex(row);
        if(rowLength - nextFreeIndex < 2) {
            return false;
        } else {
            row[nextFreeIndex] = 1;
            row[nextFreeIndex + 1] = 0;
           return true;
        }
    }

    private boolean addThreeToRow(int[] row, int rowLength) {
        int nextFreeIndex = calculateNexFreeIndex(row);
        if(rowLength - nextFreeIndex < 3) {
            return false;
        } else {
            row[nextFreeIndex] = 1;
            row[nextFreeIndex + 1] = 0;
            row[nextFreeIndex + 2] = 0;
            return true;
        }
    }
    
    private int calculateNexFreeIndex(int[] row) {
        for(int i = 0; i < row.length; i++) {
            if(row[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}
