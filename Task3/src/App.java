import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Task condition: 
    In a magical world there is an elf that loves to write the words he hears. Every time he hears 
    a word he writes it down. And since he loves words and letters so much he checks if the new word 
    is similar to the previous one. So he crosses out letters until the two words contain the same 
    letters. Please write a program that will help our kind elf.
*/

/*
Task solution:
    Create list with letters common to both words and from sum of lengths of the two words I will 
    take out 2 * length of list to find how letters he need to remove.
*/


public class App {
    private static List<Character> findCommonLetters(String word1, String word2) {
        // empty list to store common letters
        List<Character> commonLetters = new ArrayList<>();

        // fill list with common letters
        for(Character letter : word1.toCharArray()) {
            if(word2.contains(letter.toString()) && !commonLetters.contains(letter)) {
                // get count of specific letter in word1 and word2
                long countInWord1 = word1.chars().filter(c -> c == letter).count();
                long countInWord2 = word2.chars().filter(c -> c == letter).count();

                // get min of countInWord1 and countInWord2
                long count = Math.min(countInWord1, countInWord2);

                // add leletter in common letters
                for(int i = 0; i < count; i++) {
                    commonLetters.add(letter);
                }
            }
        }

        return commonLetters;
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // iput first word
        System.out.print("Enter first word: ");
        String word1 = scanner.nextLine();

        // input second word
        System.out.print("Enter second word: ");
        String word2 = scanner.nextLine();

        // list with common letters
        List<Character> commonLetters = findCommonLetters(word1, word2);

        if(commonLetters.size() > 0) {
            System.out.println("Count of letters he need to remove is " + (word1.length() + word2.length() - 2 * commonLetters.size()));
        }
        else {
            System.out.println("The two word dont have similarity!");
        }
    }
}
