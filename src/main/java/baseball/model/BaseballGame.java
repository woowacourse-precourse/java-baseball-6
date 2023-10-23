package baseball.model;

import baseball.model.collection.RandomNumbers;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {

    private static final int NO_COUNT = 0;
    private static final int THREE_STRIKE = 3;
    private final RandomNumbers randomNumbers;

    private int ball;
    private int strike;

    public BaseballGame() {
        this.ball = 0;
        this.strike = 0;
        this.randomNumbers = new RandomNumbers();
    }

    public boolean updateGameCompare(final Player player) {
        compareBall(player.getInputNumbers());
        compareStrike(player.getInputNumbers());

        return isThreeStrike();
    }

    private boolean isThreeStrike() {
        if (strike == THREE_STRIKE) {
            return true;
        }

        return false;
    }

    private void compareStrike(final List<Integer> inputNum) {
        List<Integer> randomNum = randomNumbers.getRandomNumbers();
        List<Integer> compareStrike = IntStream.range(0, 3).filter(i -> randomNum.get(i).equals(inputNum.get(i)))
                .mapToObj(randomNum::get).toList();
        this.strike = compareStrike.size();
    }

    private void compareBall(final List<Integer> inputNum) {
        List<Integer> randomNum = randomNumbers.getRandomNumbers();
        List<Integer> compareBall = IntStream.range(0, randomNum.size())
                .filter(i -> inputNum.contains(randomNum.get(i)) && inputNum.indexOf(randomNum.get(i)) != i)
                .mapToObj(randomNum::get).toList();
        this.ball = compareBall.size();
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}

