package baseball;

import baseball.controller.Computer;
import baseball.dto.GameResultDto;
import baseball.exception.RetryInputException;
import baseball.view.BallCountMessageOutputView;
import baseball.view.NumbersInputView;
import baseball.view.RetryInputView;

public class BaseBallGame {

    Computer computer;

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
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
        return computer.checkRetry(RetryInputView.input());
    }

    private void playGame() {
        computer = new Computer();

        InputPlayerNumber();
        GameResultDto gameResult = getGameResult();
        BallCountMessageOutputView.printBallCountMessage(gameResult.showMessage());
        if (gameResult.checkEnd()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        playGame();

    }
}
