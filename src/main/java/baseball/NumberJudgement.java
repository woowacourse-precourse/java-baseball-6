package baseball;

import java.util.List;

public class NumberJudgement {
    public static int countStrike(List<Integer> playerGuess, List<Integer> answerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < playerGuess.size(); i++) {
            if (playerGuess.get(i) == answerNumbers.get(i))
                strikeCount++;
        }
        return strikeCount;
    }

    public static int countBall(List<Integer> playerGuess, List<Integer> answerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < playerGuess.size(); i++) {
            if (answerNumbers.contains(playerGuess.get(i)) && playerGuess.get(i) != answerNumbers.get(i))
                ballCount++;
        }
        return ballCount;
    }
}
