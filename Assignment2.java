import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of bumpers: ");
        int numberOfBumpers = input.nextInt();

        if (numberOfBumpers >= 1 && numberOfBumpers <= 200000) {
            bumperTaken(numberOfBumpers);
        } else {
            System.out.println("\nNumber of bumpers is must between 1 and 200000. ");
        }
    }

    public static void bumperTaken (int numberOfBumpers) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the bumpers: ");
        String bumpers = input.nextLine();
        int counter1 = 0;
        int counter = 0;
        if (bumpers.length() == numberOfBumpers) {
            for (int i = 0; i < numberOfBumpers; i++) {
                if (bumpers.charAt(i) == '<' || bumpers.charAt(i) == '>') {
                    counter1++;
                } else {
                    System.out.println("\nInvalid character for bumper. ");
                }
            }
        } else {
            System.out.println("\nThe value you gave at the beginning does not match the number of bumpers.");
        }
        if (counter1 == numberOfBumpers) {
            counter =startPointLeft(numberOfBumpers,bumpers,counter);
            counter =startPointRight(bumpers,counter);
        }
        if (counter1 == numberOfBumpers) {
            System.out.println("\nNumber of start points that take the ball off the map: " + counter);
        }
    }

    public static int startPointLeft (int numberOfBumpers, String bumpers, int counter) {
        for (int i = 0; i < numberOfBumpers; i++) {
            if (bumpers.charAt(i) == '<') {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    public static int startPointRight (String bumpers, int counter) {
        for (int i = bumpers.length() - 1; i >= 0; i--) {
            if (bumpers.charAt(i) == '>') {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }
}