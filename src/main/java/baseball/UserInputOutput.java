package baseball;

import java.util.Scanner;

public class UserInputOutput {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserNumber() {
        int number;
        do {
            System.out.print("숫자를 입력해주세요: ");
            number = readUserInput();
        } while (!isValidUserNumber(number));
        return number;
    }

    public static String getRestartOrQuitInput() {
        String input;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = readUserInputAsString();
        } while (!isValidRestartOrQuitInput(input));
        return input;
    }

    private static int readUserInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자(양수)를 입력해야 합니다.");
            }
        }
    }

    private static String readUserInputAsString() {
        return scanner.nextLine();
    }

    private static boolean isValidUserNumber(int number) {
        if (number < 100 || number > 999 || !areDigitsUnique(number)) {
            System.out.println("1부터 9까지 서로 다른 3자리의 숫자를 입력해야 합니다.");
            return false;
        }
        return true;
    }

    private static boolean isValidRestartOrQuitInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            System.out.println("1 또는 2를 입력해야 합니다.");
            return false;
        }
        return true;
    }

    private static boolean areDigitsUnique(int number) {
        int[] digits = new int[10];
        while (number > 0) {
            int digit = number % 10;
            if (digits[digit] > 0) {
                return false;
            }
            digits[digit]++;
            number /= 10;
        }
        return true;
    }
}
