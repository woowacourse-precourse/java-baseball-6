package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static final int NUMBER_LENGTH = 3;
    public static final String NEW_GAME_CMD = "1";
    public static final String END_CMD = "2";
    public static final String ENTER_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getUserInput() {
        System.out.print(ENTER_USER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        if (userInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력한 숫자의 자릿수가" + NUMBER_LENGTH + " 개가 아닙니다.");
        }

        for (int i = 0; i < NUMBER_LENGTH; i++) {
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
        System.out.println(CONTINUE_MESSAGE);
        String userInput = Console.readLine();

        if (userInput.equals(NEW_GAME_CMD)) {
            return true;
        } else if (userInput.equals(END_CMD)) {
            return false;
        }
        throw new IllegalArgumentException(NEW_GAME_CMD + " 또는 " + END_CMD + "를 입력하세요.");
    }
}
