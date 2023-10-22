package baseball.view;

import baseball.model.Score;

public class OutputView {
    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String THREE_STRIKE = "3스트라이크";

    public void printResult(Score score) {
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println(NOTHING);
            return;
        } else if (score.getStrike() == 3) {
            System.out.println(THREE_STRIKE);
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(score.getBall() + BALL + score.getStrike() + STRIKE);
    }
}
