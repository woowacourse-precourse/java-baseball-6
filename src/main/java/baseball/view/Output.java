package baseball.view;

import baseball.model.GameSettings;
import baseball.model.UserNumber;

public class Output {

    private final static String MESSAGE_FOR_START = "숫자 야구 게임을 시작합니다.";
    private final static String MESSAGE_FOR_REQUEST_INPUT = "숫자를 입력해주세요 : ";
    private final static String MESSAGE_FOR_COMPLETE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String MESSAGE_FOR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String MESSAGE_FOR_STRIKE = "스트라이크";
    private final static String MESSAGE_FOR_BALL = "볼 ";
    private final static String MESSAGE_FOR_NOTHING = "낫싱";

    public static void startMessage() {
        System.out.println(MESSAGE_FOR_START);
    }

    public static UserNumber requestInputMessage() {
        System.out.print(MESSAGE_FOR_REQUEST_INPUT);
        return new UserNumber(Input.getUserInput());
    }

    public static void completeMessage() {
        System.out.println(MESSAGE_FOR_COMPLETE);
        System.out.println(MESSAGE_FOR_RESTART);
    }

    public static void hintMessage() {
        int strike = GameSettings.strike;
        int ball = GameSettings.ball;

        if (strike == 0 && ball == 0) {
            System.out.println(MESSAGE_FOR_NOTHING);
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + MESSAGE_FOR_BALL + strike + MESSAGE_FOR_STRIKE);
        } else if (strike != 0) {
            System.out.println(strike + MESSAGE_FOR_STRIKE);
        } else if (ball != 0) {
            System.out.println(ball + MESSAGE_FOR_BALL);
        }
    }
}
