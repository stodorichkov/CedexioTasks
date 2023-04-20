import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* 
Task condition:
    In a box, there's a different count of balls in different colors, which we receive as an input
    in the following format: "Color: count", until we receive an "End" command. After that, we are
    allowed to remove balls from that box, but we can't look at their color. We need to write a 
    program that prints the smallest count of balls we must take out, so we are sure there is only 
    one color left in the box.
*/

/*
Task solution:
    In order to be completely sure that there is only one color of balls left in the box, there must 
    be only one ball left in it, or in other words we will remove all the balls without one.
*/


public class App {
    private static Map<String, Integer> inputBox() {
        // create empty map with different colors balls
        Map<String, Integer> box = new HashMap<>();

        // input all balls cour: count
        while(true) {
            // input some string
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter balls by pattern(Color: count) or End to stop: ");
            String entry = scanner.nextLine();

            // break loop if input == End 
            if(entry.equals("End")) {
                break;
            }

            // check string have correct pattern
            if(Pattern.matches("\\D+:\\s{1}\\d+", entry)) {
                // split string and add new balls
                String[] entryParts = entry.split(": ");
                box.put(entryParts[0], box.getOrDefault(entryParts[0], 0) + Integer.parseInt(entryParts[1]));
            }
            else {
                System.out.println("Wrong input you must use pattern(Color: count)!");
            }
        }

        return box;
    }

    private static void countDrawnBalls(Map<String, Integer> box) {
        if(!box.isEmpty()) {
            // get count of all balls
            Integer ballsCount = 0;
            for(Integer value : box.values()) {
                ballsCount += value;
            }

            System.out.println("The Smallest count of balls we must take out, so we are sure there is only one color left in the box is " + (ballsCount - 1));
        }
        else {
            System.out.println("Box is empty!");
        }
    }
    public static void main(String[] args) throws Exception {
        //input box
        Map<String, Integer> box = inputBox();

        // print box
        System.out.println("Balls: " + box);
        
        // smallest count of balls we must take out, so we are sure there is only one color left in the box
        countDrawnBalls(box);
    }
}
