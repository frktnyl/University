import java.sql.SQLOutput;
import java.util.Scanner;

//12th week lab problems at once

public class littleApplication {
    public static void main (String[] args) {

        Boolean whatIsResult = resultIs();
        if (whatIsResult) {

            System.out.println();
            System.out.println("Welcome to application. Choose the operation you want perform. \n1- Calculator. \n2- Checking if a number is prime or not. \n3- Finding all the perfect numbers in a range. \n4- Collatz Problem.");
            Scanner operation = new Scanner(System.in);
            int appOperation = operation.nextInt();

                if (appOperation == 1) {
                    calculator();
                } else if (appOperation == 2) {
                    checkingIfaNumberPrime();
                } else if (appOperation == 3) {
                    findingPerfectNumbersInaRange();
                } else if (appOperation == 4) {
                    collatzProblem();
                }
        }
    }

    public static void collatzProblem () {
        Scanner value = new Scanner(System.in);
        System.out.println("Please give an integer for collatz problem: ");
        int number = value.nextInt();
        if (number < 1)
            System.out.println("Please give an integer bigger than 1.");
        else
            System.out.print(number);
        while (number > 1) {
            if (number % 2 == 0) {
                number = number / 2;
                System.out.print(" --> " + number);
            } else if (number % 2 != 0) {
                number = (number * 3) + 1;
                System.out.print(" --> " + number);
            }
        }
    }

    public static void findingPerfectNumbersInaRange() {
        Scanner value = new Scanner(System.in);
        System.out.println("Please enter minimum value of range: ");
        int min = value.nextInt();
        System.out.println("Please enter maximum value of range: ");
        int max = value.nextInt();
        System.out.println("The perfect numbers are: ");
        for (int i = min; i <= max; i++) {
            if (perfectNumbers(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean perfectNumbers(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        } return sum == number;
    }

    public static void checkingIfaNumberPrime() {
        Scanner value = new Scanner(System.in);
        System.out.println("Enter the integer you want to check if it is prime or not: ");
        int number = value.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        } return true;
    }

    public static void calculator () {
        Scanner value = new Scanner(System.in);
        System.out.println("Please enter the first number: ");
        double firstNumber = value.nextDouble();
        System.out.println("Please enter the second number: ");
        double secondNumber = value.nextDouble();
        System.out.println("Choose the operation you want perform. \n- Addition \n- Subtraction \n- Multiplication \n- Division");
        String operation = value.next();
        double result = 0;

            if (operation.equalsIgnoreCase("Addition")) {
                result = firstNumber + secondNumber;
                System.out.println("The result is: " + ((int) (result * 10)) / 10.0);
            } else if (operation.equalsIgnoreCase("Subtraction")) {
                result = firstNumber - secondNumber;
                System.out.println("The result is: " + ((int) (result * 10)) / 10.0);
            } else if (operation.equalsIgnoreCase("Multiplication")) {
                result = firstNumber * secondNumber;
                System.out.println("The result is: " + ((int) (result * 10)) / 10.0);
            } else if (operation.equalsIgnoreCase("Division")) {
                if (secondNumber == 0) {
                    System.out.println("The denominator is cannot be zero. Please try again with another value.");
                } else {
                    result = firstNumber / secondNumber ;
                    System.out.println("The result is: " + ((int) (result * 10)) / 10.0);
                }
            } else
                System.out.println("Invalid operation! Please try again.");
    }

    public static boolean resultIs () {
        Scanner info = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = info.nextLine();
        System.out.println("Enter your email address: (example = example@example.com) ");
        String email = info.nextLine();
        System.out.println("Enter your phone number: (example = 5*********) ");
        String phone = info.nextLine();
        System.out.println("Enter your age: ");
        int age = info.nextInt();

        String nameCapitalized = capitalize(name);
        Boolean phoneValid = isPhoneValid(phone);
        Boolean ageValid = isAgeValid(age);
        Boolean emailValid = isEmailValid(email);

        if (ageValid && emailValid && phoneValid) {
            System.out.println("Hello " + nameCapitalized + ". You have successfully logged in!");
            return true;
        } else {
            if (ageValid && phoneValid) {
                System.out.println("Your email addresses is incorrect. Please try again!");
                return false;
            } else if (emailValid && phoneValid) {
                System.out.println("Your age is not enough for registration. You must be older than 18!");
                return false;
            } else if (ageValid && emailValid) {
                System.out.println("Your phone number is incorrect. Please try again!");
                return false;
            } else if (ageValid) {
                System.out.println("Your email address and phone number is incorrect. Check them and try again!");
                return false;
            } else if (emailValid) {
                System.out.println("Your phone number is incorrect and your age is not enough for registration. Please try " + (18-age) + " years later!");
                return false;
            } else if (phoneValid) {
                System.out.println("Your email address is incorrect and your age is not enough for registration. Please try " + (18-age) + " years later!");
                return false;
            } else
                System.out.println("Your email address and your phone number is incorrect also your age is not enough for login. Please try after " + (18-age) + " years later!");
                return false;
        }
    }

    public static String capitalize (String name) {
        char firstLetter = name.charAt(0);
        char capitalFirstLetter = Character.toUpperCase(firstLetter);
        String nameWithoutFirstLetter = name.substring(1);
        name = capitalFirstLetter + nameWithoutFirstLetter;
        return name;
    }

    public static boolean isPhoneValid(String phone) {
        if (phone.length() == 10 && phone.charAt(0) == '5') {
            return true;
        } else
            return false;
    }

    public static boolean isEmailValid(String email) {
        if (email.contains("@") && email.contains(".com")) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isAgeValid(int age) {
         if (age < 18) {
            return false;
        } else {
            return true;
        }
    }
}


