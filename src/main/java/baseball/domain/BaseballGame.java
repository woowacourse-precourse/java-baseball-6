package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final BaseballNumbers gameNumbers;

    public BaseballGame() {
        this.gameNumbers = generateRandomNumbers();
    }

    public Hint guess(final BaseballNumbers userGuess) {
        int strikes = countStrikes(userGuess);
        int balls = countBalls(userGuess)-strikes;
        return new Hint(strikes, balls);
    }

    private int countStrikes(final BaseballNumbers userGuess) {
        return gameNumbers.countMatchingNumbersAtSamePosition(userGuess);
    }

    private int countBalls(final BaseballNumbers userGuess) {
        return gameNumbers.countMatchingNumbers(userGuess);
    }

    private BaseballNumbers generateRandomNumbers() {
        List<BaseballNumber> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            BaseballNumber randomNumber = generateRandomBaseballNumber();
            addNumberIfNotContains(computer, randomNumber);
        }
        return new BaseballNumbers(computer);
    }

    private BaseballNumber generateRandomBaseballNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return new BaseballNumber(randomNumber);
    }

    private void addNumberIfNotContains(final List<BaseballNumber> numbers, final BaseballNumber number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
