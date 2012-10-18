package reilly.projecteuler.problems.complete;

/**
 * User: john
 * Date: 18/10/12
 * Time: 19:39
 */
public class Problem19 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int number = calculateSundays();
        System.out.println("result = " + number);
        System.out.println("Time taken = " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    private static int calculateSundays() {
        int sundaysFirstOfMonthCounter = 0;
        int daysSinceFirstJan1900 = 1;
        int yearCounter = 1901;
        for(int i = 1; i <= 12 * 100 ; i++) {
            if(daysSinceFirstJan1900 % 7 == 6) {
                sundaysFirstOfMonthCounter++;
            }
            int monthMod = i % 12;
            if(checkFor31DayMonth(monthMod)) {
                daysSinceFirstJan1900 += 31;
            } else if(checkFor30DayMonth(monthMod)) {
                daysSinceFirstJan1900 += 30;
            } else if((monthMod == 2) && checkForLeapYear(yearCounter)) {
                daysSinceFirstJan1900 += 29;
            } else {
                daysSinceFirstJan1900 += 28;
            }
            if(i % 12 == 0) {
                yearCounter++;
            }
        }
        return sundaysFirstOfMonthCounter;
    }

    private static boolean checkFor31DayMonth(int monthMod) {
        if(monthMod == 1) {
            return true;
        } else if(monthMod == 3) {
            return true;
        } else if(monthMod == 5) {
            return true;
        } else if(monthMod == 7) {
            return true;
        } else if(monthMod == 8) {
            return true;
        } else if(monthMod == 10) {
            return true;
        } else if(monthMod == 0) {
            return true;
        }
        return false;
    }

    private static boolean checkFor30DayMonth(int monthMod) {
        if(monthMod == 4) {
            return true;
        } else if(monthMod == 6) {
            return true;
        } else if(monthMod == 9) {
            return true;
        } else if(monthMod == 11) {
            return true;
        }
        return false;
    }

    private static boolean checkForLeapYear(int year) {
        if(year % 100 == 0) {
            if(year % 400 != 0) {
                return false;
            }
        }
        if(year % 4 == 0) {
            return true;
        }
        return false;
    }
}
