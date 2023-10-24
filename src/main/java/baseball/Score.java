package baseball;

import static baseball.SimpleMessageBundle.BALL;
import static baseball.SimpleMessageBundle.NOTHING;
import static baseball.SimpleMessageBundle.STRIKE;

public class Score {

    private int strike;
    private int ball;

    public Score(Num target, Num guess) {
        for (int i = 0; i < Num.DIGIT; i++) {
            if (target.getDigitAt(i) == guess.getDigitAt(i)) {
                strike++;
            } else if (target.contains(guess.getDigitAt(i))) {
                ball++;
            }
        }
    }

    public void printScore() {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        } else {
            StringBuilder sb = new StringBuilder();
            if (ball != 0) {
                sb.append(ball).append(BALL).append(" ");
            }
            if (strike != 0) {
                sb.append(strike).append(STRIKE);
            }
            System.out.println(sb);
        }
    }

    public boolean isCorrect() {
        return strike == Num.DIGIT;
    }
}
