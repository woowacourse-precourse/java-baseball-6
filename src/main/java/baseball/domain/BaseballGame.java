package baseball.domain;

import static baseball.console.Constant.INT_ZERO;
import static baseball.console.Constant.RESULT_BALL;
import static baseball.console.Constant.RESULT_NOTHING;
import static baseball.console.Constant.RESULT_STRIKE;

import baseball.console.Input;
import baseball.console.Output;
import baseball.util.Computer;
import baseball.util.GameFactory;

public class BaseballGame {

    private BaseballNumbers computerNumbers;
    private BaseballNumbers userNumbers;

    public void playGame() {
        computerNumbers = Computer.generateComputerNumbers();
        do {
            tryGame();
        } while (!isCorrect());
        Output.printBaseballGameTermination();
    }

    private void tryGame() {
        userNumbers = receiveUserNumbers();
        Output.printBaseballGameHint(printResult());
    }

    private BaseballNumbers receiveUserNumbers() {
        return GameFactory.createUserNumbers(Input.receiveBaseballNumber());
    }

    private boolean isCorrect() {
        return computerNumbers.equals(userNumbers);
    }

    private String printResult() {

        StringBuilder stringBuilder = new StringBuilder();

        int strikeCount = computerNumbers.getStrikeCount(userNumbers);
        int ballCount = computerNumbers.getBallCount(userNumbers);

        if (strikeCount == INT_ZERO && ballCount == INT_ZERO) {
            stringBuilder.append(RESULT_NOTHING);
        } else if (strikeCount != INT_ZERO && ballCount != INT_ZERO) {
            stringBuilder.append(ballCount).append(RESULT_BALL).append(" ")
                    .append(strikeCount).append(RESULT_STRIKE);
        } else if (strikeCount != INT_ZERO) {
            stringBuilder.append(strikeCount).append(RESULT_STRIKE);
        } else if (ballCount != INT_ZERO) {
            stringBuilder.append(ballCount).append(RESULT_BALL);
        }
        return stringBuilder.toString();
    }
}
