package baseball.model;

import static baseball.enums.Message.BALL;
import static baseball.enums.Message.STRIKE;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Score {
    private int ballCount;
    private int strikeCount;

    public static Score from(List<Integer> inputIntegers, List<Integer> randomIntegers) {
        Objects.requireNonNull(inputIntegers);
        Objects.requireNonNull(randomIntegers);

        Score score = new Score();

        IntStream.range(0, inputIntegers.size())
                .forEach(i -> traverseInputValue(inputIntegers, i, randomIntegers, score));

        return score;
    }

    private static void traverseInputValue(List<Integer> inputValue, int i, List<Integer> randomIntegers, Score score) {
        Objects.requireNonNull(inputValue);
        Objects.requireNonNull(randomIntegers);
        Objects.requireNonNull(score);

        for (int j = 0; j < randomIntegers.size(); j++) {

            if (Objects.equals(inputValue.get(i), randomIntegers.get(j)) && i == j) {
                score.increaseStrikeCount();
                break;
            }

            if (Objects.equals(inputValue.get(i), randomIntegers.get(j))) {
                score.increaseBallCount();
            }
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public String getScoreBoardMessage() {
        return (getBallCountMessage() + " " + getStrikeCountMessage());
    }

    public String getBallCountMessage() {
        return (this.getBallCount() != 0) ? this.getBallCount() + BALL.getMessage() : "";
    }

    public String getStrikeCountMessage() {
        return (this.getStrikeCount() != 0) ? this.getStrikeCount() + STRIKE.getMessage() : "";
    }

    public boolean isStrikeOut() {
        return this.strikeCount == 3;
    }

    public boolean isNothing() {
        return this.getStrikeCount() + this.getBallCount() == 0;
    }
}
