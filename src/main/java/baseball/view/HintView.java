package baseball.view;

import baseball.domain.Hint.Ball;
import baseball.domain.Hint.Hint;
import baseball.domain.Hint.Nothing;
import baseball.domain.Hint.Strike;

public class HintView {

    public static final String STRIKE_TEXT = "스트라이크";
    public static final String BALL_TEXT = "볼";
    public static final String NOTHING_TEXT = "낫싱";


    public static void displayHintMessage(Hint hint) {

        Ball ball = hint.getBall();
        Strike strike = hint.getStrike();
        Nothing nothing = hint.isNothing();

        StringBuilder hintBuilder = new StringBuilder();
        if (ball.getCount() > 0) {
            hintBuilder.append(ball + BALL_TEXT);
        }

        if (!hintBuilder.isEmpty()) { //비어있지 않으면 공백 넣기
            hintBuilder.append(" ");
        }

        if (strike.getCount() > 0) {
            hintBuilder.append(strike + STRIKE_TEXT);
        }

        if (nothing.isStatus()) {
            hintBuilder.append(NOTHING_TEXT);
        }

        System.out.println(hintBuilder.toString());
    }
}
