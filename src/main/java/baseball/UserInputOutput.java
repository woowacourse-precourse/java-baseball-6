package baseball;

import java.util.Scanner;

public class UserInputOutput {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserNumber() {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("숫자를 입력해주세요: ");
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                if (input.length() != 3 || !areDigitsUnique(number)) {
                    throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 숫자를 입력해주세요.");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 다른 것이 입력되었습니다.");
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        return number;
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static String getRestartOrQuitInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = scanner.nextLine();
            if (input.equals("1") || input.equals("2")) {
                validInput = true;
            } else {
                System.out.println("1 또는 2를 입력해야 합니다.");
            }
        }
        return input;
    }

    private static boolean areDigitsUnique(int number) {
        int[] digits = new int[10];
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digits[digit] > 0) {
                throw new IllegalArgumentException("2개 이상의 중복되는 숫자가 입력되었습니다.");
            }
            digits[digit]++;
            count++;
            number /= 10;
        }
        if (count != 3) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 숫자를 입력해주세요.");
        }
        return true;
    }
}
