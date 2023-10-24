package baseball;

import static baseball.GameState.PROGRESS_STATE;

public class Output {

    public static int startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return PROGRESS_STATE;
    }

    public static void drawOutResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }

    public static void notifyGameSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
