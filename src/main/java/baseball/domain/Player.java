package baseball.domain;

import static baseball.utils.Constants.TOTAL_BALL_COUNTS;
import static baseball.utils.GameMessage.GAME_SUCCESS_MESSAGE;
import static baseball.utils.GameMessage.INPUT_REQUEST_MESSAGE;

import baseball.domain.wrapped.Ball;
import baseball.domain.wrapped.Strike;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        PlayerNumbers playerNumbers;
        while (strike.isLessThan(TOTAL_BALL_COUNTS)) {
            OutputView.printMessageWithoutNewLine(INPUT_REQUEST_MESSAGE);
            String playerInput = InputView.getPlayerInput();
            playerNumbers = new PlayerNumbers(playerInput);

            strike = new Strike(playerNumbers.checkStrikeCount(randomNumbers));
            ball = new Ball(playerNumbers.checkBallCount(randomNumbers));
            printBallCount();
        }
        OutputView.printMessage(GAME_SUCCESS_MESSAGE);
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
