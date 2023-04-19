import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Task condition: 
    In a magical world there is an elf that loves to write the words he hears. Every time he hears 
    a word he writes it down. And since he loves words and letters so much he checks if the new word 
    is similar to the previous one. So he crosses out letters until the two words contain the same 
    letters. Please write a program that will help our kind elf.
*/

/*
Task solution:
    Create set with letters common to both words and from sum of lengths of the two words I will 
    take out 2 * length of set to find how letters he need to remove.
*/


public class App {
    public static void main(String[] args) throws Exception {
        // set with common letters
        Set<Character> commonLetters = new HashSet<>();

        Scanner scanner = new Scanner(System.in);

        // iput first word
        System.out.print("Enter first word: ");
        String word1 = scanner.nextLine();

        // input second word
        System.out.print("Enter second word: ");
        String word2 = scanner.nextLine();

        // fill set with common letters
        for(Character letter : word1.toCharArray()) {
            if(word2.contains(letter.toString())) {
                commonLetters.add(letter);
            }
        }

        // print final result
        System.out.println("Count of letters he need to remove is " + (word1.length() + word2.length() - 2 * commonLetters.size()));
    }
}
