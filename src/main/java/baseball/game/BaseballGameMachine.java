package baseball.game;

import baseball.util.BaseballGameNumbersConvertor;
import baseball.util.RetryInputConvertor;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameMachine {

    private static final int RETRY = 1;
    private static final int EXIT = 2;

    private final BaseballGameNumbers baseballGameNumbers = new BaseballGameNumbers();

    public void start() {
        OutputView.printGameStartingPrompt();
        Grader grader = baseballGameNumbers.getRandomNumbersGrader();

        while (true) {
            List<Integer> playerNumbers = getPlayerNumbers();
            ScoreBoard scoreBoard = grader.grade(playerNumbers);
            OutputView.printGameResult(scoreBoard.ballCount(), scoreBoard.strikeCount());

            if (isFullStrike(scoreBoard, baseballGameNumbers.getNumberSize())) {
                OutputView.printWinningPrompt(baseballGameNumbers.getNumberSize());
                break;
            }
        }

        askPlayerToRetry();
    }

    private List<Integer> getPlayerNumbers() {
        String playerNumbersInput = InputView.requestNumbersInput();
        List<Integer> playerNumbers = BaseballGameNumbersConvertor.convertBaseballGameNumbers(
            playerNumbersInput, baseballGameNumbers.getNumberSize());

        baseballGameNumbers.validatePlayerNumbers(playerNumbers);
        return playerNumbers;
    }

    private boolean isFullStrike(ScoreBoard scoreBoard, int numberSize) {
        return scoreBoard.strikeCount() == numberSize;
    }

    private void askPlayerToRetry() {
        String playerRetryInput = InputView.requestPlayerRetryInput(RETRY, EXIT);
        int playerRetryNumber = RetryInputConvertor.convertRetryInput(playerRetryInput);

        if (playerRetryNumber == RETRY) {
            start();
        }
    }
}
