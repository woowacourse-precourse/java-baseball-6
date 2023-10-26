package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class RoundResult {
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";

    private int strikeCount = 0;
    private int ballCount = 0;

    private RoundResult() {
    }

    public static RoundResult of(List<Integer> guessNumbers, List<Integer> answerNumbers) {
        RoundResult roundResult = new RoundResult();
        roundResult.matchNumbers(guessNumbers, answerNumbers);
        return roundResult;
    }


    public void matchNumbers(List<Integer> guessNumbers, List<Integer> answerNumbers) {
        IntStream.range(0, guessNumbers.size()).forEach(i -> {
            if (isStrike(i, guessNumbers, answerNumbers)) {
                this.strikeCount++;
            } else if (isBall(i, guessNumbers, answerNumbers)) {
                this.ballCount++;
            }
        });
    }

    private boolean isStrike(int index, List<Integer> guessNumbers, List<Integer> answerNumbers) {
        return guessNumbers.get(index).equals(answerNumbers.get(index));
    }

    private boolean isBall(int index, List<Integer> guessNumbers, List<Integer> answerNumbers) {
        return answerNumbers.contains(guessNumbers.get(index));
    }

    public boolean isCorrect() {
        return this.strikeCount == Baseball.NUMBERS_COUNT;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    @Override
    public String toString() {
        if (this.strikeCount == 0 && this.ballCount == 0) {
            return NOTHING;
        }
        StringBuilder result = new StringBuilder();
        if (this.ballCount > 0) {
            result.append(this.ballCount).append(BALL);
        }
        if (this.strikeCount > 0) {
            if (this.ballCount > 0) {
                result.append(" ");
            }
            result.append(this.strikeCount).append(STRIKE);
        }
        return result.toString();
    }
}
