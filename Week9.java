import java.util.Scanner;

public class Week9 {
    public static void main(String[] args) {
        //Palindrome word
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome word.");
        } else
            System.out.println(word + " is not a palindrome word.");
    }

    public static boolean isPalindrome(String word) {
        int a = 0;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) == word.charAt(word.length() - 1 - i)) {
                a++;
            }
        } return (a == word.length() / 2);
    }
}