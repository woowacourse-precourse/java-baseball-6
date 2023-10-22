package baseball;

import baseball.controller.Computer;
import baseball.dto.GameResultDto;
import baseball.view.BallCountMessageOutputView;
import baseball.view.NumbersInputView;

public class BaseBallGame {

    Computer computer;

    public void run() {
        do {
            computer = new Computer();
            gameStart();

        } while(isRetry() == true);
    }

    private void InputPlayerNumber() {
        computer.getPlayerNumbers(NumbersInputView.input());
    }
    private GameResultDto getGameResult() {
        return computer.calculateGameResult();
    }

    private boolean isRetry() {

        return true;
    }
    private void gameStart() {
        while (true) {
            InputPlayerNumber();
            GameResultDto gameResult = getGameResult();
            BallCountMessageOutputView.printBallCountMessage(gameResult.showMessage());
            if (gameResult.showIsEnd() == true) {
                return;
            }
        }

    }
}
