package baseball.view;

import baseball.domain.Judgement;

public class JudgementView {

    private static final String BALL_MESSAGE = "%d볼 ";

    private static final String STRIKE_MESSAGE = "%d스트라이크";

    private static final String NOTHING_MESSAGE = "낫싱";

    public static void print(final Judgement judgement) {
        if (judgement.isNothing()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (judgement.hasBall()) {
            System.out.printf(BALL_MESSAGE, judgement.getBall());
        }
        if (judgement.hasStrike()) {
            System.out.printf(STRIKE_MESSAGE, judgement.getStrike());
        }
        System.out.println();
    }
}
