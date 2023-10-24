package baseball.view;

import baseball.domain.GameResult;

public class ResultView {

    public static void showResult(GameResult gameResult) {
        if (gameResult.isStrikeOut()) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (gameResult.hasBall() || gameResult.hasStrike()) {
            System.out.println(gameResult.getBallCount() + "볼 " + gameResult.getStrikeCount() + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }
}
