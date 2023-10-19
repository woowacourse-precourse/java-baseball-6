package baseball.view;

import static baseball.Constants.NUMBER_COUNTS;

public class OutputView {

    public static void showStartDescription() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void askNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void informGameOver() {
        System.out.println(NUMBER_COUNTS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void askContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
