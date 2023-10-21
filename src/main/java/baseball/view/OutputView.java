package baseball.view;

import baseball.model.Result;

public class OutputView {

    private final static String NOTHING = "낫싱";
    private final static String BALL = "볼 ";
    private final static String STRIKE = "스트라이크 ";

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printBallStrike(Result result) {
        System.out.println(
                result.getBall() + BALL
                        + result.getStrike() + STRIKE
        );
    }


}
