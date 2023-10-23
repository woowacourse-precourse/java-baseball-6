package baseball.view;

import baseball.game.Hint;

public class OutputView {
    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printHint(Hint hint) {
        int ball = 0;
        int strike = 0;

        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼" + strike + "스트라이크");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }
}
