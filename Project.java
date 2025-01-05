import java.util.Scanner;

//input for try
//ZERO GİBİRİSH ONE GİBİRİSH ZERO GİBİRİSH ZEROGİBİRİSH ONE GİBİRİSHZEROGİBİRİSH ZEROGİBİRİSH ZERO GİBİRİSH ZERO GİBİRİSHZERO GİBİRİSH ONE GİBİRİSHONE GİBİRİSH ZERO GİBİRİSHONE GİBİRİSH ZERO GİBİRİSH ZERO GİBİRİSH ZEROGİBİRİSH ONE GİBİRİSHZERO GİBİRİSH ZERO GİBİRİSH ZEROGİBİRİSH ZERO GİBİRİSHONE GİBİRİSH ONE GİBİRİSHZERO GİBİRİSH ONE GİBİRİSHZERO GİBİRİSH ZEROGİBİRİSHONE GİBİRİSH ZEROGİBİRİSH ONE GİBİRİSH ONE GİBİRİSH ZERO GİBİRİSHZERO GİBİRİSH ONEGİBİRİSH ONE GİBİRİSH ZERO GİBİRİSH ZEROGİBİRİSH ONEGİBİRİSH ONE GİBİRİSH ZEROGİBİRİSH ONE GİBİRİSH ZEROGİBİRİSH ONE GİBİRİSHZERO GİBİRİSH ZERO GİBİRİSH ONEGİBİRİSH ZERO GİBİRİSH ZERO GİBİRİSH ZEROGİBİRİSH ONE GİBİRİSH ONEGİBİRİSH ZERO GİBİRİSH ONE GİBİRİSH ZEROGİBİRİSH ONE

public class Project {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the message : ");

        String paragraph = input.nextLine();
        int placement = 0;
        int transport = 0;
        String[] words = new String[numberOfZerosAndOnes(paragraph)];
        int[] numbers = new int[numberOfZerosAndOnes(paragraph)];
        char[] asciiChar = new char[numberOfZerosAndOnes(paragraph) / 8];

        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == 'Z' && paragraph.charAt(i + 1) == 'E') {
                if (paragraph.charAt(i + 2) == 'R' && paragraph.charAt(i + 3) == 'O') {
                    if (i + 3 < paragraph.length()) {
                        words[placement] = "ZERO";
                        placement++;
                        i = i + 3;
                    }
                }
            } else if (i + 2 < paragraph.length() && paragraph.charAt(i) == 'O') {
                if (paragraph.charAt(i + 1) == 'N') {
                    if (paragraph.charAt(i + 2) == 'E') {
                        words[placement] = "ONE";
                        placement++;
                        i = i + 2;
                    }
                }
            }
        }

        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        for (int i = 0; i < words.length; i++) {
            if (words[transport].equals("ZERO")) {
                numbers[transport] = 0;
                transport++;
            } else if (words[transport].equals("ONE")) {
                numbers[transport] = 1;
                transport++;
            }
        }
        transport = 0;

        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        for (int i = 0; i < numbers.length / 8; i++) {
            int count = 0;
            int x;
            for (int j = 0; j < 8; j++) {
                x = (int) (numbers[i * 8 + j] * Math.pow(2, 7 - j));
                count += x;
            }
            asciiChar[transport] = (char) count;
            transport++;
        }
        for (int i = 0; i < numberOfZerosAndOnes(paragraph) / 8; i++) {
            if (asciiChar[i] == '0') {
                asciiChar[i] = 'O';
            } else if (asciiChar[i] == '1'){
                asciiChar[i] = 'I';
            } else if (asciiChar[i] == '2'){
                asciiChar[i] = 'Z';
            } else if (asciiChar[i] == '3'){
                asciiChar[i] = 'E';
            } else if (asciiChar[i] == '4'){
                asciiChar[i] = 'A';
            } else if (asciiChar[i] == '6'){
                asciiChar[i] = 'G';
            } else if (asciiChar[i] == '8'){
                asciiChar[i] = 'B';
            }
            System.out.print(asciiChar[i]);
        }
    }

    public static int numberOfZerosAndOnes (String paragraph) {
        int count = 0;

        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == 'Z' && paragraph.charAt(i + 1) == 'E') {
                if (paragraph.charAt(i + 2) == 'R' && paragraph.charAt(i + 3) == 'O') {
                    if (i + 3 < paragraph.length()) {
                        count++;
                        i = i + 3;
                    }
                }
            }
            if (i + 2 < paragraph.length() && paragraph.charAt(i) == 'O') {
                if (paragraph.charAt(i + 1) == 'N') {
                    if (paragraph.charAt(i + 2) == 'E') {
                        count++;
                        i = i + 2;
                    }
                }
            }
        }
        return count;
    }
}
