package baseball.view;

import baseball.constant.Game;

public class GameOutput {
    public static void startBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void endBaseballGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void exitBaseballGame() {
        System.out.println("게임을 완전히 종료하였습니다.");
    }

    public static void progressInputNumber() {
        System.out.print("숫자를 입력해주세요 :");
    }

    public static void findCorrectAnswer() {
        System.out.println(Game.STRIKE_COUNT + Game.STRIKE + "\n"
                + Game.STRIKE_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
