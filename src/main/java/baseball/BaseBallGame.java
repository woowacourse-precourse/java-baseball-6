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
        do {
            computer = new Computer();
            playGame();

        } while(isRetry() == true);
    }

    private void InputPlayerNumber() {
        computer.getPlayerNumbers(NumbersInputView.input());
    }

    private GameResultDto getGameResult() {
        return computer.calculateGameResult();
    }

    private boolean isRetry() {
        String userInput = RetryInputView.input();

        if (userInput.equals("1")) {
            return true;
        }
        if (userInput.equals("2")) {
            return false;
        }

        throw new RetryInputException();

    }

    private void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            InputPlayerNumber();
            GameResultDto gameResult = getGameResult();
            BallCountMessageOutputView.printBallCountMessage(gameResult.showMessage());
            if (gameResult.showIsEnd() == true) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }

    }
}
