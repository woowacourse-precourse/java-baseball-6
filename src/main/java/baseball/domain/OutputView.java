package baseball.domain;

import java.util.List;

public class OutputView {

    public String gameResult(List<Integer> result) {
        int strike = result.get(0);
        int ball = result.get(1);
        String resultBall = "";
        String resultStrike = "";
        if (strike + ball == 0) {
            return "낫싱";
        }
        if (strike > 0) {
            resultStrike = strike + "스트라이크";
        }
        if (ball > 0) {
            resultBall = ball + "볼 ";
        }
        return resultBall + resultStrike;
    }

    public void gameFinished() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
