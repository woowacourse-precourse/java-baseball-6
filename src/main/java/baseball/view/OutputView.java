package baseball.view;

import baseball.model.Hint;

public class OutputView {
    public static void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printSuccessAndEndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printHintMessage(Hint hint) {
        System.out.println(hint.toString());
    }
}
