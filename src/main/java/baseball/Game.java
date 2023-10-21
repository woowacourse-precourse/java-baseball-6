package baseball;

import baseball.controller.Core;
import baseball.controller.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    int ONE_OR_TWO_LEN = Configuration.ONE_OR_TWO_LEN;
    int CONTINUE = Configuration.CONTINUE;

    View view = new View();
    Core core = new Core();
    Validation validation = new Validation();

    public void launch() {
        view.showOpening();
        boolean running = true;

        while (running) {
            core.run();

            view.showClosing();
            view.askOneOrTwo();

            running = checkContinue();
        }
    }

    public boolean checkContinue() {
        String input = Console.readLine();
        validation.validateInputLength(input, ONE_OR_TWO_LEN);

        int inputNum = input.charAt(0) - '0';
        validation.validateOneOrTwo(inputNum);

        return inputNum == CONTINUE;
    }
}
