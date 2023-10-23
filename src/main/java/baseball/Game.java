package baseball;

import baseball.controller.Core;
import baseball.controller.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void launch() {
        View view = new View();

        view.showOpening();
        boolean running = true;

        while (running) {
            Core core = new Core();

            core.run();

            view.showClosing();
            view.askOneOrTwo();

            running = checkContinue();
        }
    }

    public boolean checkContinue() {
        Validation validation = new Validation();

        String input = Console.readLine();
        validation.validateInputLength(input, 1);

        int inputNum = Integer.parseInt(input);
        validation.validateOneOrTwo(inputNum);

        int CONTINUE = 1;
        return inputNum == CONTINUE;
    }
}
