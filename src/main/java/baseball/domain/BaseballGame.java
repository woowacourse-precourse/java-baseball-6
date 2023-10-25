package baseball.domain;

import baseball.console.Constant;
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

    private String printResult() {

        StringBuilder stringBuilder = new StringBuilder();

        int strikeCount = computerNumbers.getStrikeCount(userNumbers);
        int ballCount = computerNumbers.getBallCount(userNumbers);

        if (strikeCount == Constant.INT_ZERO && ballCount == Constant.INT_ZERO) {
            stringBuilder.append(Constant.RESULT_NOTHING);
        } else if (strikeCount != Constant.INT_ZERO && ballCount != Constant.INT_ZERO) {
            stringBuilder.append(ballCount).append(Constant.RESULT_BALL).append(" ")
                    .append(strikeCount).append(Constant.RESULT_STRIKE);
        } else if (strikeCount != Constant.INT_ZERO) {
            stringBuilder.append(strikeCount).append(Constant.RESULT_STRIKE);
        } else if (ballCount != Constant.INT_ZERO) {
            stringBuilder.append(ballCount).append(Constant.RESULT_BALL);
        }
        return stringBuilder.toString();
    }

    private boolean isCorrect() {
        return computerNumbers.equals(userNumbers);
    }
}
