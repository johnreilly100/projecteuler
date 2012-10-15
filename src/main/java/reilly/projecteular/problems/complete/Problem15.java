package reilly.projectular.problems;

/**
 * User: john
 * Date: 10/10/12
 * Time: 06:55
 */
public class Problem15 {
    static int squareSizeToCheck = 20;
    static long numberPaths = 0;
    static long[][] numberPathsOnGrid = new long[squareSizeToCheck + 1][squareSizeToCheck + 1];

    public static void main(String[] arg) {
        Problem15 project15 = new Problem15();
        numberPaths = project15.recursiveSearch(squareSizeToCheck * -1, squareSizeToCheck * -1);
        System.out.println("Number of paths = " + numberPaths);
    }

    /**
     * Returns the total number of paths to the bottom right hand corner,
     * the bottom right hand corner is always assumed to be (0,0)
     *
     * @param       x the point on the grid that you want to calculate the number of paths for
     * @return      the number of paths this square has to the bottom right hand corner
     */
    private long recursiveSearch(int x, int y) {
        long totalPaths = 0;

        // base case edge
        if(x == 0 || y == 0) {
            return 1;
        }

        // check if a square has had its paths calculated already.
        if(numberPathsOnGrid[x * -1][y * -1] != 0 ) {
            return numberPathsOnGrid[x * -1][y * -1];
        }

        // check if the opposite square has had its paths calculated already.
        if(numberPathsOnGrid[y * -1][x * -1] != 0 ) {
            numberPathsOnGrid[x * -1][y * -1] = numberPathsOnGrid[y * -1][x * -1];
            System.out.println("Opposite found = " + x + " " + y );
            return numberPathsOnGrid[x * -1][y * -1];
        }

        // search right
        totalPaths += recursiveSearch(x + 1, y);

        // if the point been checked is the opposite side of a square from the origin then the point directly down has the same
        // number of  paths as the point directly to the right.
        if(x == y) {
            totalPaths = totalPaths * 2;
            //System.out.println("Setting = " + x + " " + y + " paths = " + totalPaths);
            numberPathsOnGrid[x * -1][y * -1] = totalPaths;
            return totalPaths;
        }

        // search down
        totalPaths += recursiveSearch(x, y + 1);

        numberPathsOnGrid[x * -1][y * -1] = totalPaths;
        return totalPaths;
    }
}
