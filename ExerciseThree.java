import java.util.*;

public class ExerciseThree {

    public static void main(String[] args) {

        System.out.println("Test case 1");
        // Ordered Map entry for all stock data. Test Case
        Map<String, Integer> stockEntries1 = new TreeMap<String,Integer>(){{
            put("Day 01", 10);
            put("Day 02", 1);
            put("Day 03", 8);
            put("Day 04", 55);
            put("Day 05", 38);
            put("Day 06", 2);
            put("Day 07", 123);
            put("Day 08", 42);
            put("Day 09", 54);
            put("Day 10", 53);
        }};
        System.out.println("entries1 :" +getProfitDays(stockEntries1));


        System.out.println("Test case 2");
        // Ordered Map entry for all stock data. Test Case
        Map<String, Integer> stockEntries2 = new TreeMap<String,Integer>(){{
            put("Day 01", 9);
            put("Day 02", 1);
            put("Day 03", 8);
            put("Day 04", 55);
            put("Day 05", 8);
            put("Day 06", 2);
            put("Day 07", 123);
            put("Day 08", 42);
            put("Day 09", 54);
            put("Day 10", 1 );
        }};

        System.out.println("entries2 :" + getProfitDays(stockEntries2));


        System.out.println("Test case 3");
        // Ordered Map entry for all stock data. Test Case
        Map<String, Integer> stockEntries3 = new TreeMap<String,Integer>(){{
        }};

        System.out.println("entries3 :" + getProfitDays(stockEntries3));

    }

    // Helper function to return [BuyDay, SellDay] List of Buy and Sell Days
    private static List<String> getProfitDays(Map<String, Integer> stockDays) {

        // if no stock days return empty list
        if(stockDays.entrySet().isEmpty())
            return Arrays.asList();

        String minDay = "";
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        List<String> result = new ArrayList<>();

        /*
        Traverse through all stock entries and check whether the current value of that day
        is smaller than the recorded buy (minimum value) or else check if the profit made between the current day
        and the minumum (buy date) is greater than the global maximum profit made,
        if so return the minimum as the buy date and the current day as the sell date
          */

        for (Map.Entry<String, Integer> stockEntry : stockDays.entrySet()) {
            int currStockPrice = stockEntry.getValue();
            String currDay = stockEntry.getKey();
            if (currStockPrice < minimum) {
                minimum = currStockPrice;
                minDay = currDay;
            }
            else if (currStockPrice - minimum > maximum) {
                maximum = currStockPrice - minimum;
                result = Arrays.asList(minDay, currDay);
            }
        }
        return result;
    }
}
