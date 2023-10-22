package baseball.model;

import baseball.constant.OutputMessage;
import baseball.model.collection.RandomNumbers;
import java.util.List;
import java.util.stream.IntStream;

public class GameCompare {
    private static final int ZERO = 0;
    private static final int THREE_STRIKE = 3;
    private final RandomNumbers randomNumbers;

    private int ball;
    private int strike;

    public GameCompare() {
        this.ball = 0;
        this.strike = 0;
        this.randomNumbers = new RandomNumbers();
    }

    public boolean updateGameCompare(Player player) {
        compareBall(player.getInputNumbers());
        int expectedStrike = compareStrike(player.getInputNumbers());
        if (expectedStrike == THREE_STRIKE) {
            return true;
        }
        return false;
    }

    public String showResult() {
        StringBuilder stringBuilder = new StringBuilder();
        isBall(stringBuilder);
        isStrike(stringBuilder);
        isBallAndStrike(stringBuilder);
        isGameOver(stringBuilder);
        return stringBuilder.toString();
    }

    private void isBall(StringBuilder stringBuilder) {
        if (ball != ZERO) {
            stringBuilder.append(ball);
            stringBuilder.append(OutputMessage.BALL);
            stringBuilder.append(OutputMessage.SPACE);
        }
    }

    private void isStrike(StringBuilder stringBuilder) {
        if (strike != ZERO) {
            stringBuilder.append(strike);
            stringBuilder.append(OutputMessage.STRIKE);
        }
    }

    private void isBallAndStrike(StringBuilder stringBuilder) {
        if (ball == ZERO && strike == ZERO) {
            stringBuilder.append(OutputMessage.NOTHING);
            stringBuilder.append(OutputMessage.SPACE);
        }
    }

    private void isGameOver(StringBuilder stringBuilder) {
        if (strike == THREE_STRIKE) {
            stringBuilder.append(OutputMessage.LINE_BREAK);
            stringBuilder.append(OutputMessage.THREE_STRIKE_MESSAGE);
        }
    }

    private int compareStrike(List<Integer> inputNum) {
        List<Integer> randomNum = randomNumbers.getRandomNumbers();
        List<Integer> compareStrike = IntStream.range(0, 3).filter(i -> randomNum.get(i).equals(inputNum.get(i)))
                .mapToObj(randomNum::get).toList();
        this.strike = compareStrike.size();
        return strike;
    }

    private void compareBall(List<Integer> inputNum) {
        List<Integer> randomNum = randomNumbers.getRandomNumbers();
        List<Integer> compareBall = IntStream.range(0, randomNum.size())
                .filter(i -> inputNum.contains(randomNum.get(i)) && inputNum.indexOf(randomNum.get(i)) != i)
                .mapToObj(randomNum::get).toList();
        this.ball = compareBall.size();
    }
}

