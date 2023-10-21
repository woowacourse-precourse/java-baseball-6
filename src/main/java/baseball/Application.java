package baseball;

import baseball.controller.Game;
import baseball.controller.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int ONE_OR_TWO_LEN = 1;
    private static final int EXIT = 1;

    public static void main(String[] args) {
        View.showOpening();
        boolean running = true;

        while (running) {
            Game.run();

            View.showClosing();
            View.askOneOrTwo();

            running = checkExit();
        }
    }

    private static boolean checkExit() {
        String input = Console.readLine();
        Validation.validateInputLength(input, ONE_OR_TWO_LEN);
        
        int inputNum = input.charAt(0) - '0';
        Validation.validateOneOrTwo(inputNum);

        return inputNum == EXIT;
    }
}
