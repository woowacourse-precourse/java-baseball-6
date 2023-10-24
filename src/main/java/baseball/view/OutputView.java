package baseball.view;

import baseball.model.HumanModel;

public class OutputView {
    public static void displayGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void displayScoreboard(HumanModel humanModel) {
        int strike = humanModel.getStrike();
        int ball = humanModel.getBall();

        if (humanModel.getNothing() != 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void displayGameExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
