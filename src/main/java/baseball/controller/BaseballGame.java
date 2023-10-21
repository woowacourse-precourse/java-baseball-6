package baseball.controller;

import static baseball.view.InputView.userInput;
import static baseball.view.OutputView.gameStartMessage;
import static baseball.view.OutputView.userInputMessage;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import java.util.List;


public class BaseballGame {

    public void gameStart() {
        List<Integer> computerNumber = ComputerNumber.makeComputerNumber();
        gameStartMessage();
        userInputMessage();
        UserNumber userNumber = new UserNumber(userInput());
    }

    public int[] countBallStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int[] cntBallStrike = {0, 0};

        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                cntBallStrike[1]++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                cntBallStrike[0]++;
            }
        }

        return cntBallStrike;
    }

    //public static
}
