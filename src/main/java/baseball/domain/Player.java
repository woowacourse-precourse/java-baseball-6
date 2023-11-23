package baseball.domain;

import static baseball.utils.Constants.TOTAL_BALL_COUNTS;

import baseball.domain.wrapped.Ball;
import baseball.domain.wrapped.Strike;
import baseball.utils.GameMessage;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Player {
    private RandomNumbers randomNumbers = new RandomNumbers();
    private Computer computer = new Computer();
    private Strike strike;
    private Ball ball;

    public Player() {
    }

    public void init() {
        computer.init();
        strike = new Strike(0);
        ball = new Ball(0);
    }

    public void play() {
        while (isGameContinuing()) {
            PlayerNumbers playerNumbers = getPlayerNumbers();
            updateStrikeAndBallCounts(playerNumbers);
            printBallCount();
        }
        OutputView.printMessage(GameMessage.GAME_SUCCESS_MESSAGE.getMessage());
    }

    private boolean isGameContinuing() {
        return strike.isLessThan(TOTAL_BALL_COUNTS);
    }

    private PlayerNumbers getPlayerNumbers() {
        OutputView.printMessageWithoutNewLine(GameMessage.INPUT_REQUEST_MESSAGE.getMessage());
        String playerInput = InputView.getPlayerInput();
        return new PlayerNumbers(playerInput);
    }

    private void updateStrikeAndBallCounts(PlayerNumbers playerNumbers) {
        List<Integer> playerNumbersList = playerNumbers.getPlayerNumbers();
        List<Integer> randomNumbersList = randomNumbers.getRandomNumbers();

        strike = new Strike(BallCountCalculator.calculateStrikeCount(playerNumbersList, randomNumbersList));
        ball = new Ball(BallCountCalculator.calculateBallCount(playerNumbersList, randomNumbersList));
    }

    public void printBallCount() {
        String result = "";
        if (ball.getResultMessage().equals("0볼") && strike.getResultMessage().equals("0스트라이크")) {
            result = "낫싱";
        }
        if (ball.getResultMessage().equals("0볼") && !strike.getResultMessage().equals("0스트라이크")) {
            result = strike.getResultMessage();
        }
        if (!ball.getResultMessage().equals("0볼") && strike.getResultMessage().equals("0스트라이크")) {
            result = ball.getResultMessage();
        }
        if (!ball.getResultMessage().equals("0볼") && !strike.getResultMessage().equals("0스트라이크")) {
            result = ball.getResultMessage() + " " + strike.getResultMessage();
        }
        OutputView.printMessage(result);
    }
}
