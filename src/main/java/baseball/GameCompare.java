package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class GameCompare {
    private static final int ZERO = 0;
    private static final int THREE_STRIKE = 3;
    private int ball;
    private int strike;
    private List<Integer> randomNumbers = RandomNum.createRandomNum();

    public GameCompare() {
    }

    public boolean updateGameCompare(Player player) {
        compareBall(player.getInputNumbers(), randomNumbers);
        int expectedStrike = compareStrike(player.getInputNumbers(), randomNumbers);
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
        }
    }

    private void isGameOver(StringBuilder stringBuilder) {
        if (strike == THREE_STRIKE) {
            stringBuilder.append(OutputMessage.THREE_STRIKE_MESSAGE);
        }
    }

    private int compareStrike(List<Integer> randomNum, List<Integer> inputNum) {
        List<Integer> compareStrike = IntStream.range(0, 3).filter(i -> randomNum.get(i).equals(inputNum.get(i)))
                .mapToObj(randomNum::get).toList();
        this.strike = compareStrike.size();
        return strike;
    }

    private void compareBall(List<Integer> randomNum, List<Integer> inputNum) {
        List<Integer> compareBall = IntStream.range(0, randomNum.size())
                .filter(i -> inputNum.contains(randomNum.get(i)) && inputNum.indexOf(randomNum.get(i)) != i)
                .mapToObj(randomNum::get).toList();
        this.ball = compareBall.size();
    }

}

