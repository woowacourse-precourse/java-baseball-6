package baseball.view;

import baseball.ValidateNumbers;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayerInput {
    static final String RESTART_GAME = "1";
    static final String EXIT_GAME = "2";

    public static ValidateNumbers inputNums() {
        String input = readLine();

        ValidateNumbers validateInput;
        try {
            validateInput = new ValidateNumbers(input);
        } catch (IllegalArgumentException e) {
            //여러개의 예외들을 하나로 묶어서 종료시키려고 만든 구문인데
            //너무 좀 그런가...? 애초에 작동은 잘 하나..?
            throw new IllegalStateException();
        }

        return validateInput;
    }

    public static boolean isExitGame() {
        String input = readLine();

        if(!isValidateInput(input)) {
            throw new IllegalStateException();
        }

        if (input.equals(EXIT_GAME)) {
            return true;
        }
        return false;
    }

    private static boolean isValidateInput(String input) {
        if (input.equals(RESTART_GAME) || input.equals(EXIT_GAME)) {
            return true;
        }
        return false;
    }

}
