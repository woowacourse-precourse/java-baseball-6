package baseball.view;

import baseball.domain.HintResult;

public class OutputView {

    private OutputView() {
    }

    public static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printHint(HintResult hintResult) {
        System.out.println(hintResult);
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
