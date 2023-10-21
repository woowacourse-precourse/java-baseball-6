package baseball.domain;

import baseball.dto.GameResult;
import java.util.List;
import java.util.function.Function;

public class Computer {

    private static final int GENERATE_COUNT = 3;
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    private Numbers computerNumbers;
    private Numbers userNumbers;

    public void generateNumber(final Function<Integer, List<Integer>> computerNumberGenerator) {
        List<Integer> randomNumbers = computerNumberGenerator.apply(GENERATE_COUNT);
        computerNumbers = new Numbers(randomNumbers);
    }

    public void addUserNumber(final String inputUserNumber) {
        this.userNumbers = Numbers.createUserNumbers(inputUserNumber);
    }

    public GameResult createResult() {
        List<Integer> compareResults = computerNumbers.createCompareResult(userNumbers);
        return new GameResult(compareResults.get(STRIKE_INDEX), compareResults.get(BALL_INDEX));
    }
}
