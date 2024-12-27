import java.util.Scanner;

public class Week14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        int sum = sumOfElements(array);
        System.out.println("The sum of the elements of the array is: " + sum);
        int averageOfSum = sum / size;
        System.out.println("The average of the elements of the array is: " + averageOfSum);
    }

    public static int sumOfElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}