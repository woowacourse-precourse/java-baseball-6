package baseball.model;

import baseball.view.UserInput;
import java.util.List;

public class Game {

    public static final String END_GAME = "3스트라이크";
    private final ComputerNumberGenerator computerNumberGenerator;
    private final UserInput userInput;

    public Game(ComputerNumberGenerator computerNumberGenerator, UserInput userInput) {
        this.computerNumberGenerator = computerNumberGenerator;
        this.userInput = userInput;
    }


    public String play() {
        List<Integer> computerNumbers = computerNumberGenerator.getComputerNumber();
        List<Integer> userNumbers = userInput.userInputToIntegerList();

        return getResult(computerNumbers, userNumbers);
    }

    private String getResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        Strike strike = new Strike();
        Ball ball = new Ball();

        for (int i = 0; i < 3; i++) {
            if (isStrike(computerNumbers, userNumbers, i)) {
                strike.increaseStrikeCount();
                continue;
            }
            if (isBall(computerNumbers, userNumbers, i)) {
                ball.increaseBallCount();
            }
        }

        return formatResult(strike, ball);
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        return computerNumbers.get(index)
                .equals(userNumbers.get(index));
    }

    private boolean isBall(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        return computerNumbers.contains(userNumbers.get(index));
    }

    private String formatResult(Strike strike, Ball ball) {
        int strikeCount = strike.getStrikeCount();
        int ballCount = ball.getBallCount();
        if (strikeCount == 3) {
            return END_GAME;
        }
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        appendIfNotZero(result, ballCount, "볼");
        appendIfNotZero(result, strikeCount, "스트라이크");
        return result.toString();
    }

    private void appendIfNotZero(StringBuilder result, int count, String comment) {
        if (count > 0) {
            result.append(count).append(comment).append(" ");
        }
    }
}
