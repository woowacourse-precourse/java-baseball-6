package baseball;

import baseball.controller.Core;
import baseball.controller.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    final int CONTINUE = 1;

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
        validation.validateInputLength(input, 1);

        int inputNum = Integer.parseInt(input);
        validation.validateOneOrTwo(inputNum);

        return inputNum == CONTINUE;
    }
}
