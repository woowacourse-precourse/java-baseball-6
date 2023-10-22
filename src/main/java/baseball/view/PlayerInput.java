package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.validation.CheckExitInput;

public class PlayerInput {
    public static final String RESTART_GAME = "1";
    public static final String EXIT_GAME = "2";

    public static String getInput() {
        return readLine();
    }

    public static boolean isGameRestartInput() {
        String input = readLine();
        CheckExitInput check = new CheckExitInput();
        check.checkValidationOfExit(input);
        return input.equals(RESTART_GAME);
    }
}
