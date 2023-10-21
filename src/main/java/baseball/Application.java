package baseball;

import baseball.controller.Core;
import baseball.controller.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int ONE_OR_TWO_LEN = Configuration.ONE_OR_TWO_LEN;
    private static final int CONTINUE = Configuration.CONTINUE;

    public static void main(String[] args) {
        View.showOpening();
        boolean running = true;

        while (running) {
            Core.run();

            View.showClosing();
            View.askOneOrTwo();

            running = checkContinue();
        }
    }

    public static boolean checkContinue() {
        String input = Console.readLine();
        Validation.validateInputLength(input, ONE_OR_TWO_LEN);

        int inputNum = input.charAt(0) - '0';
        Validation.validateOneOrTwo(inputNum);

        return inputNum == CONTINUE;
    }
}
