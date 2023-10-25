package view;

import static model.Constant.INPUT_MESSAGE;

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
