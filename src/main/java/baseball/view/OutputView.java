package baseball.view;

import baseball.model.computer.Score;

public class OutputView {

    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String THREE_STRIKE = "3스트라이크";

    public void printResult(Score score) {
        Integer ball = score.getBall();
        Integer strike = score.getStrike();

        if (strike == 3) {
            System.out.println(THREE_STRIKE);
            System.out.println(SUCCESS);
            return;
        }
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball != 0 && strike == 0) {
            System.out.println(score.getBall() + BALL);
            return;
        }
        if (ball == 0 && strike != 0) {
            System.out.println(score.getStrike() + STRIKE);
            return;
        }

        System.out.println(score.getBall() + BALL + score.getStrike() + STRIKE);
    }
}
