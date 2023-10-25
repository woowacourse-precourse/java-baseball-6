package baseball;

import java.util.List;
import java.util.Objects;

public final class NumberJudgement {

    private NumberJudgement() {
    }

    public static int countStrike(List<Integer> playerGuess, List<Integer> answerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < playerGuess.size(); i++) {
            if (Objects.equals(playerGuess.get(i), answerNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int countBall(List<Integer> playerGuess, List<Integer> answerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < playerGuess.size(); i++) {
            if (answerNumbers.contains(playerGuess.get(i)) &&
                    !Objects.equals(playerGuess.get(i), answerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
