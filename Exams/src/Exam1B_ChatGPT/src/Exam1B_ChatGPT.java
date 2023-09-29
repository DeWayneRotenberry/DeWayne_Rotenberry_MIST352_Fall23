/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class Exam1B_ChatGPT {
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        // Display welcome message
        System.out.println("Welcome! Please provide some text input.");

        // Ask user for text input
        String userInput = scanner.nextLine();

        // Printout the length of the provided input
        System.out.println("Length of input: " + userInput.length());

        // Ask user for character to find in the input
        System.out.print("Enter a character to find: ");
        char charToFind = scanner.next().charAt(0);

        // Printout the location of the first occurrence of that character
        int charIndex = userInput.indexOf(charToFind);
        if (charIndex != -1) {
            System.out.println("The first occurrence of '" + charToFind + "' is at index: " + charIndex);
        } else {
            System.out.println("The character '" + charToFind + "' was not found in the input.");
        }
    }

}
