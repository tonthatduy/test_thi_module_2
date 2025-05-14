package thi_thu_module_2.quan_ly.common;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    private static Scanner scanner = new Scanner(System.in);

    public static String validateInput(String regex, String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Không Được Để Trống. Nhập lại!");
                continue;
            }
            if (Pattern.matches(regex, input)) {
                return input;
            }
            System.err.println(errorMessage);
        }
    }

    public static int inputYear() {
        int year = 0;
        LocalDate localDate = LocalDate.now();
        do {
            System.out.println("Nhập năm sản xuất");
            year = Integer.parseInt(scanner.nextLine());
            if (localDate.getYear() < year) {
                System.err.println(" Năm không hợp lệ. Nhập Lại");
            } else {
                return year;
            }
        } while (true);
    }

    public static double validateDouble(double min, double max, String message) {
        double number;
        do {
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number > 0 && number >= min && number <= max) {
                    return number;
                }
                System.err.println(message);
                System.out.print("Nhập lại: ");
            } catch (NumberFormatException e) {
                System.err.println("Không Hợp Lệ");
                System.out.print("Nhập lại: ");
            }

        } while (true);
    }

    public static int validateInteger(int min, int max, String message) {
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());

                if (number > 0 && number >= min && number <= max) {
                    return number;
                }
                System.out.println(message);
                System.out.print("Nhập lại: ");
            } catch (NumberFormatException e) {
                System.err.println("Không Hợp Lệ");
                System.out.println("Nhập lại");
            }
        } while (true);
    }
}
