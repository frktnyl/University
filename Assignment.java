    import java.util.Scanner;

    public class Assignment {
        public static void main(String[] args) {
            Scanner values = new Scanner(System.in);
            System.out.println("Please enter number of reports and length of the sequence of the number in the reports: (example: n m)");
            int n = values.nextInt();
            int m = values.nextInt();

            if ((1 <= n && n <= 1000) && (1 <= m && m <= 1000)) {
                operation(n, m);
            } else if (1 <= n && n <= 1000) {
                System.out.println("Length of the sequence of the number in the reports must be between 1 and 1000.");
            } else if (1 <= m && m <= 1000) {
                System.out.println("Number of reports must be between 1 and 1000.");
            } else
                System.out.println("Number of reports and length of the sequence of the number in the reports must be between 1 and 1000.");
        }

        //Basamak sayısı + boşluk sayısından farklı basamak sayısı varsa inputun sistem safe olup olmadığını kontrol eden methodu çağırmayacak şekilde ayarladım.
        public static void operation(int line, int digit) {
            Scanner lines = new Scanner(System.in);
            System.out.println("Please enter reports line by line and numbers must separated by spaces: ");

            int numberOfSafetyReports = 0;
            for (int i = 1; i <= line; i++) {
                String report = lines.nextLine();
                if (report.length() == digit + (digit - 1)) {
                    if (checkingForSafety(report, digit)) {
                        numberOfSafetyReports++;
                    }
                } else
                    System.out.println("Length of the sequence of the number in this report is not correct. This report will not effect the answer! ");
            }
            System.out.println(numberOfSafetyReports);
        }

        //The levels are either all increasing or all decreasing. Any two adjacent levels differ by at least zero and at most three.
        public static boolean checkingForSafety(String report, int digit) {
            boolean Increasing = true;
            boolean Decreasing = true;
            int counter = 0;

            for (int i = 0; i < report.length() - 2; i = i + 2) {
                int currentDigit = report.charAt(i);
                int nextDigit = report.charAt(i + 2);
                if ((48 <= currentDigit && currentDigit <= 57) && (48 <= nextDigit && nextDigit <= 57)) {
                    counter++;
                }
            }
            if (counter == digit - 1) {
                if (spaceCounter(report) == digit - 1 && checkingSpaceLocation(report, digit)) {
                    for (int j = 0; j < report.length() - 2; j = j + 2) {
                        int currentDigit = report.charAt(j);
                        int nextDigit = report.charAt(j + 2);

                        int result = nextDigit - currentDigit;
                        if (result > 3 || result < -3) {
                            return false;
                        }
                        if (nextDigit > currentDigit) {
                            Increasing = false;
                        } else if (nextDigit < currentDigit) {
                            Decreasing = false;
                        }
                    }
                } else {
                    System.out.println("Report is incorrect. This report will not effect the answer! ");
                    return false;
                }
            } else {
                System.out.println("Invalid character. This report will not effect the answer! ");
                return false;
            }
            return Increasing || Decreasing;
        }

        public static int spaceCounter(String report) {
            int count = 0;
            for (int i = 0; i < report.length() - 1; i++) {
                if (report.charAt(i) == ' ') {
                    count++;
                }
            }
            return count;
        }

        public static boolean checkingSpaceLocation(String report, int digit) {
            int x = 0;
            for (int i = 1; i < report.length() - 1; i = i + 2) {
                if (report.charAt(i) == ' ') {
                    x++;
                }
            }
            return x == digit - 1;
        }
    }
