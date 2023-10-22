package baseball.view;

import baseball.model.Result;

public class OutputView {

    private final static String NOTHING = "낫싱";
    private final static String BALL = "볼 ";
    private final static String STRIKE = "스트라이크 ";
    private final static String ALL_STRIKE = "3스트라이크";
    private final static String FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String START = "숫자 야구 게임을 시작합니다.";

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printBallStrike(Result result) {

        if (result.getStrike() == 0) {
            System.out.println(result.getBall() + BALL);
        } else if (result.getBall() == 0) {
            System.out.println(result.getStrike() + STRIKE);
        } else {
            System.out.println(
                    result.getBall() + BALL
                            + result.getStrike() + STRIKE);

        }

    }

    public void printGameFinish() {
        System.out.println(ALL_STRIKE);
        System.out.println(FINISH);
    }

    public void printGameStart() {
        System.out.println(START);
    }


}
