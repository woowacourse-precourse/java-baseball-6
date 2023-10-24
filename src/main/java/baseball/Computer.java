package baseball;

import static baseball.constants.Game.BALL;
import static baseball.constants.Game.NOTHING;
import static baseball.constants.Game.STRIKE;

public class Computer {
    private final Answer answer;

    public Computer() {
        answer = new Answer();
    }

    public void printResult(String guess) {
        int strikes = getStrikesCount(guess);
        int balls = getBallsCount(guess);

        String comment = (strikes == 0 && balls == 0) ? NOTHING : ((balls > 0 ? balls + BALL + " " : "") +
                (strikes > 0 ? strikes + STRIKE : ""));
        System.out.println(comment);
    }

    private int getBallsCount(String guess) {
        int balls = 0;
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            if (answer.getAnswer().contains("" + guessChar)) {
                balls++;
            }
        }
        return balls - getStrikesCount(guess);
    }

    public int getStrikesCount(String guess) {
        int strikes = 0;
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char answerChar = answer.getAnswer().charAt(i);
            if (guessChar == answerChar) {
                strikes++;
            }
        }
        return strikes;
    }
}
