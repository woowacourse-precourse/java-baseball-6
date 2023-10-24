package baseball;

import static baseball.enums.MessageEnum.GAME_END;
import static baseball.enums.MessageEnum.GAME_START;

import baseball.controller.Computer;
import baseball.domain.RetryChecker;
import baseball.dto.GameResultDto;
import baseball.enums.MessageEnum;
import baseball.exception.RetryInputException;
import baseball.view.BallCountMessageOutputView;
import baseball.view.NumbersInputView;
import baseball.view.RetryInputView;

public class BaseBallGame {

    Computer computer;

    public void run() {
        System.out.println(GAME_START);
        do {
            computer = new Computer();
            playGame();

        } while(isRetry());
    }

    private void InputPlayerNumber() {
        computer.getPlayerNumbers(NumbersInputView.input());
    }

    private GameResultDto getGameResult() {
        return computer.calculateGameResult();
    }

    private boolean isRetry() {
        RetryChecker retryChecker = new RetryChecker(RetryInputView.input());
        return retryChecker.isRetry();
    }

    private void playGame() {

        InputPlayerNumber();
        GameResultDto gameResult = getGameResult();
        BallCountMessageOutputView.printBallCountMessage(gameResult.showMessage());
        if (gameResult.checkEnd()) {
            System.out.println(GAME_END);
            return;
        }
        playGame();

    }
}
