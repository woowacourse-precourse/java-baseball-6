package baseball;

import baseball.controller.Core;
import baseball.controller.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    final int CONTINUE = 1;

    public void launch() {
        View view = new View();

        view.showOpening();
        boolean running = true;

        while (running) {
            Core core = new Core();

            core.run();

            view.showClosing();
            view.askOneOrTwo();

            String input = Console.readLine();
            running = checkContinue(input);
        }
    }

    public boolean checkContinue(String input) {
        Validation.validateInputStyle(input, 1);

        int inputNum = Integer.parseInt(input);
        Validation.validateOneOrTwo(inputNum);

        return inputNum == CONTINUE;
    }
}
