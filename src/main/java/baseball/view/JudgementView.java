package baseball.view;

import baseball.domain.Judgement;

public class JudgementView {

    private static final String JUDGEMENT_MESSAGE = "%d볼 %d스트라이크\n";

    private static final String NOTHING_MESSAGE = "낫싱\n";

    public static void print(final Judgement judgement) {
        if (judgement.isNothing()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        System.out.printf(JUDGEMENT_MESSAGE, judgement.getBall(), judgement.getStrike());
    }
}
