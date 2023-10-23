package view;

import static validation.Constant.INPUT_MESSAGE;
import static validation.Constant.QUIT;
import static validation.Constant.RESTART;
import static validation.Constant.WRONG_RESTART_INPUT;

import camp.nextstep.edu.missionutils.Console;
import validation.Validation;

public class InputView {
    public static String setPlayerInput() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static int setRestartInput() {
        int restart = Integer.parseInt(Console.readLine());

        Validation.validateRestart(restart);
        return restart;
    }
}
