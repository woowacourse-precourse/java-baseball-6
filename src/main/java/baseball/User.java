package baseball;

import baseball.Game.QuitInput;
import camp.nextstep.edu.missionutils.Console;

public class User {
    User() {

    }

    public String getGameInput() {
        String input = Console.readLine();

        if (!isGameInputRight(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return input;
    }

    private boolean isGameInputRight(String input) {
        if (!isInputLenRight(input, 3)) {
            return false;
        }

        if (!isInputNumber(input)) {
            return false;
        }

        if (!isInputValueDiff(input)) {
            return false;
        }

        return true;
    }

    public String getQuitInput() {
        String input = Console.readLine();

        if (!isQuitInputRight(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return input;
    }

    private boolean isQuitInputRight(String input) {
        if (!isInputLenRight(input, 1)) {
            return false;
        }

        if (!input.equals(QuitInput.RESTART.getQuitInput()) && !input.equals(QuitInput.QUIT.getQuitInput())) {
            return false;
        }

        return true;
    }

    private boolean isInputLenRight(String input, int len) {
        if (input.length() != len) {
            return false;
        }

        return true;
    }

    private boolean isInputNumber(String input) {
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);

            if (!Character.isDigit(c) || c == '0') {
                return false;
            }
        }

        return true;
    }

    private boolean isInputValueDiff(String input) {
        boolean[] used = new boolean[9];

        for (int i = 0; i < 3; i++) {
            int num = input.charAt(i) - '0';

            if (used[num - 1]) {
                return false;
            }

            used[num - 1] = true;
        }

        return true;
    }
}
