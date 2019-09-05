import java.util.Arrays;
import java.util.List;

public class ExerciseOne {
    public static void main(String[] args) {

        // Test Cases
        System.out.println("Test case 1 ");
        System.out.println(calculateChange(0));

        System.out.println("Test case 2 ");
        System.out.println(calculateChange(10));

        System.out.println("Test case 3 ");
        System.out.println(calculateChange(83));

        System.out.println("Test case 4 ");
        System.out.println(calculateChange(55));

        System.out.println("Test case 5 ");
        System.out.println(calculateChange(125));
    }
    // Helper function to calculate change and return division counts
    private static List<Integer> calculateChange(int cents) {
        // return a zero array if cent value is less or equal to 0
        if (cents <= 0)
            return Arrays.asList(0, 0, 0, 0);

        // state of counts for all divisions
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        // run loop while cents can still be divided with existing divisions
        while (cents != 0) {
            if (cents / 25 != 0) {
                quarters += cents / 25;
                cents = cents % 25;
            } else if (cents / 10 != 0) {
                dimes = cents / 10;
                cents = cents % 10;
            } else if (cents / 5 != 0) {
                nickels += cents / 5;
                cents = cents % 5;
            } else {
                pennies += cents;
                cents = 0;
            }
        }

        // return list of division counts in format - "{quarter}, {dimes}, {nickels}, {pennies}
        return Arrays.asList(quarters, dimes, nickels, pennies);
    }
}