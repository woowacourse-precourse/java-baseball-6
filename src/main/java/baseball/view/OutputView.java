package baseball.view;

import baseball.GameResult;

public class OutputView {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameResult(final String gameResult) {
        System.out.println(gameResult);
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
