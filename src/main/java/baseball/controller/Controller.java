package baseball.controller;

import baseball.ComputerNumberGenerator;
import baseball.message.ConsoleMessage;
import baseball.model.CheckCount;
import baseball.model.ComputerNumber;
import baseball.model.RandomNumberGenerator;
import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

public class Controller {
    private final ComputerNumberGenerator numberGenerator;
    public Controller(final ComputerNumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        System.out.println(ConsoleMessage.START_GAME.getMessage());
        reGame();
    }

    private void reGame() {
        int gameFlag;

        do {
            playGame();
            gameFlag = Input.inputGameFlag();
        } while (gameFlag == 1);
    }

    private void playGame() {
        ComputerNumber computerNumber = new ComputerNumber(numberGenerator);
        int strike = 0;

        while (strike != 3) {
            List<Integer> userNumber = Input.inputUserNumber();

            CheckCount checkCount = new CheckCount(computerNumber, userNumber);
            List<Integer> ballStrike = checkCount.compareNumber();

            Output.printCount(ballStrike);
            strike = ballStrike.get(1);
        }
        System.out.println(ConsoleMessage.RE_GAME.getMessage());
    }
}
