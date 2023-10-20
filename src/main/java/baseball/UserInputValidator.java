package baseball;

import java.util.Scanner;

public class UserInputValidator {
    public int[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int[] userInput = new int[3];

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = scanner.nextLine();

            if (input.length() != 3) {
                System.out.println("입력은 3자리 숫자여야 합니다.");
                continue;
            }

            try {
                for (int i = 0; i < 3; i++) {
                    userInput[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
                    if (userInput[i] < 1 || userInput[i] > 9) {
                        throw new NumberFormatException();
                    }
                }
                if (userInput[0] == userInput[1] || userInput[0] == userInput[2] || userInput[1] == userInput[2]) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("1부터 9 사이의 서로 다른 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("서로 다른 숫자를 입력해주세요.");
            }
        }

        return userInput;
    }
}
