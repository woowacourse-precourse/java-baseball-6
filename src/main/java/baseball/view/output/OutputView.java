package baseball.view.output;

import baseball.model.Result;

public class OutputView {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }

    public static void printGameOver() {
        System.out.println("게임 종료");
    }
}
