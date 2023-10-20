package baseball.domain;

import java.util.List;

public class Player {

    private int ballCount;
    private int strikeCount;

    public Player() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void compareToAnswerNumbers(Opponent opponent, List<Integer> guessNumbers) {
        validateGuessNumbers(guessNumbers);

        List<Integer> answerNumbers = opponent.getAnswerNumbers();
        ballCount = 0;
        strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (answerNumbers.get(i).equals(guessNumbers.get(i))) {
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

    private void validateGuessNumbers(List<Integer> guessNumbers) {
        if (guessNumbers.size() != 3) {
            throw new IllegalArgumentException();
        }

        if (guessNumbers.contains(0)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < guessNumbers.size() - 2; i++) {
            if (guessNumbers.get(i).equals(guessNumbers.get(i + 1))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean isEqualToAnswerNumbers() {
        return strikeCount == 3;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
