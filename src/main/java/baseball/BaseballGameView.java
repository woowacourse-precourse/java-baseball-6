package baseball;

public class BaseballGameView {
    static void showStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
    }

    static void showWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printLoopResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    static void showNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    static void showGameContinueInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
