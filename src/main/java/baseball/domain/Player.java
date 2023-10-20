package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int ballCount;
    private int strikeCount;

    public Player() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void compareToAnswerNumbers(Opponent opponent, List<Integer> guessNumbers) {
        List<Integer> answerNumbers = opponent.getAnswerNumbers();
        ballCount = 0;
        strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (answerNumbers.get(i) == guessNumbers.get(i)) {
                strikeCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            int guessNumber = guessNumbers.get(i);

            if (answerNumbers.contains(guessNumber)) {
                ballCount++;
            }
        }

        ballCount -= strikeCount;
    }
}
