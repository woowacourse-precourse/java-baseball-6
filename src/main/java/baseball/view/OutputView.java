package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_STRIKE_MESSAGE = "3스트라이크";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStrikeAndBall(int ball, int strike) {

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printSuccess() {
        System.out.println(SUCCESS_STRIKE_MESSAGE);
        System.out.println(SUCCESS_MESSAGE);
    }
}
