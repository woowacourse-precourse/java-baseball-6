package baseball.ui;

import static baseball.constant.GameConstants.MAX_NUMBER_LENGTH;

import baseball.constant.GameStatus;

public class GameOutput {
    private GameOutput() {
    }

    public static void showStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void showWinMessage() {
        System.out.println(MAX_NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printLoopResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
        if (ball > 0 && strike > 0) {
            System.out.print(" ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void showNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void showGameContinueInputMessage() {
        System.out.println("게임을 새로 시작하려면 " + GameStatus.CONTINUE.getStatus() + ", 종료하려면 " + GameStatus.STOP.getStatus()
                + "를 입력하세요.");
    }
}
