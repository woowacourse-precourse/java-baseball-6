package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 자릿수가 3개가 아닙니다.");
        }

        for (int i = 0; i < 3; i++) {
            char digit = userInput.charAt(i);
            if (!Character.isDigit(digit) || digit < '1' || digit > '9') {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력하세요.");
            }

            for (int j = 0; j < i; j++) {
                if (digit == userInput.charAt(j)) {
                    throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
                }
            }
        }
        return userInput;
    }

    public static boolean isNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
}
