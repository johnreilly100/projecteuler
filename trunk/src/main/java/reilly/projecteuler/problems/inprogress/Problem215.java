package reilly.projecteuler.problems.inprogress;

import java.util.ArrayList;

/**
 * User: john
 * Date: 24/10/12
 * Time: 18:13
 */
public class Problem215 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem215 problem215 = new Problem215();
        int[] testRow = new int[9];
        System.out.println("testRow.length = " + testRow.length);
        for(int i = 0; i < testRow.length; i++) {
            testRow[i] = -1;
        }
//        problem215.printArray(testRow);
//        problem215.addThreeToRow(testRow, 9);
//        problem215.printArray(testRow);
//        problem215.addThreeToRow(testRow, 9);
//        problem215.printArray(testRow);
//        problem215.addThreeToRow(testRow, 9);
//        problem215.printArray(testRow);
//        problem215.addThreeToRow(testRow, 9);
//        problem215.printArray(testRow);
//        problem215.addThreeToRow(testRow, 9);
//        problem215.printArray(testRow);
        ArrayList<int []> rowConfigurations = new ArrayList<int[]>();
        problem215.calculateAllLayoutsForOneRow(testRow, 9, rowConfigurations);
        System.out.println("rowConfigurations size = " + rowConfigurations.size());
        for(int[] row: rowConfigurations) {
            problem215.printArray(row);
        }

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

    int calculateNumberOfWaysOfFormingWall(ArrayList<int []> layoutsForOneRow, int numberOfRows) {
        int total = 0;
        for(int i = 0; i < numberOfRows; i++) {

        }
        return total;
    }

    boolean checkCanTwoRowsBeStackedOnTopOfEachOther(int[] row1, int[] row2) {
        for(int i = 2; i < row1.length; i++) {
            if(row1[i] == 1 && row2[i] == 1) {
                return false;
            }
        }
        return true;
    }

    void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(i == array.length -1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i]);
            }
        }
    }
    
    int[] copyArray(int[] source) {
        int[] destination = new int[source.length];
        System.arraycopy(source, 0, destination,0 , source.length);
        return destination;
    }

//    ArrayList<int []> calculateAllBlockLayoutsForOneRow(ArrayList<int []> rowConfiguration, int rowSize) {
//
//
//
//        for(int[] row: rowConfiguration) {
//            if(row.length == rowSize)
//            // add a block of two
//
//            // add a block of three
//        }
//        List<Integer> rowLayout = new ArrayList<Integer>();
//
//        return rowConfigurations;
//    }
//
    void calculateAllLayoutsForOneRow(int[] row, int rowLength, ArrayList<int []> rowConfigurations) {
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

    boolean checkIfRowIsFull(int[] row, int rowLength) {
        if(row[rowLength - 1] != -1) {
            return true;
        } else {
            return false;
        }
    }

    boolean addTwoToRow(int[] row, int rowLength) {
        int nextFreeIndex = calculateNexFreeIndex(row);
        if(rowLength - nextFreeIndex < 2) {
            return false;
        } else {
            row[nextFreeIndex] = 1;
            row[nextFreeIndex + 1] = 0;
           return true;
        }
    }

    boolean addThreeToRow(int[] row, int rowLength) {
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
    
    int calculateNexFreeIndex(int[] row) {
        for(int i = 0; i < row.length; i++) {
            if(row[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}
