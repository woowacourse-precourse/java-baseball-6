package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputOut {
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public InputOut() {
    }

    public static String userInput() {
        return Console.readLine();
    }

    public static void showUserScore(final int strike, final int ball) {
        String message;

        if (strike == 0 && ball == 0) {
            message = "낫싱";
        } else if (strike == 0) {
            message = ball + "볼";
        } else if (ball == 0) {
            message = strike + "스트라이크";
        } else {
            message = ball + "볼 " + strike + "스트라이크";
        }

        System.out.println(message);
    }
}
