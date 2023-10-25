package baseball.controller;

import baseball.message.ConsoleMessage;
import baseball.model.CheckCount;
import baseball.model.ComputerNumber;
import baseball.model.RandomNumberGenerator;
import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

public class Controller {

    public void run() {
        int strike = 0;
        int gameFlag;

        System.out.println(ConsoleMessage.START_GAME.getMessage());

        do {
            playGame(strike);
            gameFlag = Input.inputGameFlag();
        } while (gameFlag == 1);
    }

    private void playGame(int strike) {
        ComputerNumber computerNumber = new ComputerNumber(new RandomNumberGenerator());

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
