package baseball;

import baseball.controller.Core;
import baseball.controller.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int CONTINUE = 1;

    public static void main(String[] args) {
        View.showOpening();
        boolean running = true;

        while (running) {
            Core.run();

            View.showClosing();

            String input = Console.readLine();
            running = checkContinue(input);
        }
    }

    public static boolean checkContinue(String input) {
        Validation.validateOneOrTwo(input, 1);

        int inputNum = Integer.parseInt(input);
        
        return inputNum == CONTINUE;
    }
}
