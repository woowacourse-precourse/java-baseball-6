package baseball.view;

import java.util.List;

public class GameResultView {
    private static final String THREE_STRIKE_PRINT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String AFTER_GAME_PRINT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    public void printNotThreeStrikeResult(List<Integer> strikeAndBallCount) {
        int strikeCount = strikeAndBallCount.get(STRIKE_INDEX);
        int ballCount = strikeAndBallCount.get(BALL_INDEX);

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public void printThreeStrikeResult() {
        System.out.println("3스트라이크");
        System.out.println(THREE_STRIKE_PRINT);
        System.out.println(AFTER_GAME_PRINT);
    }

    public void printCreateController() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}