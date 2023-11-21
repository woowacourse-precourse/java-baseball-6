package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readUserNum() {
        try {
            String userNum = Console.readLine();
            validateLength(userNum);
//            validateIsUnique();
            validateRange(userNum);

            return convertStringToInt(userNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readUserNum();
        }
    }

    public static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 세자리여야 합니다. 재입력 하세요.");
        }
    }

    public static void validateRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (num < '1' || num > '9') {
                throw new IllegalArgumentException("입력값은 1~9사이 숫자 여야합니다. 재입력 하세요.");
            }
        }
    }

    public static int convertStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다. 재입력 하세요.");
        }
    }
}

