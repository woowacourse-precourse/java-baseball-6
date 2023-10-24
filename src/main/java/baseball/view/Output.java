package baseball.view;

import baseball.model.Settings;

public class Output {
    private final static String MESSAGE_FOR_START = "숫자 야구 게임을 시작합니다.";
    private final static String MESSAGE_FOR_REQUEST_INPUT = "숫자를 입력해주세요 : ";
    private final static String MESSAGE_FOR_COMPLETE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String MESSAGE_FOR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String MESSAGE_FOR_STRIKE = "스트라이크";
    private final static String MESSAGE_FOR_BALL = "볼 ";
    private final static String MESSAGE_FOR_NOTHING = "낫싱";

    public static void StartMessage() {
        System.out.println(MESSAGE_FOR_START);
    }

    public static void RequestInputMessage() {
        System.out.print(MESSAGE_FOR_REQUEST_INPUT);
    }

    public static void CompleteMessage() {
        System.out.println(MESSAGE_FOR_COMPLETE);
        System.out.println(MESSAGE_FOR_RESTART);
    }

    public static void HintMessage() {
        if (Settings.strike == 0 && Settings.ball == 0) {
            System.out.println(MESSAGE_FOR_NOTHING);
        } else if (Settings.strike != 0 && Settings.ball != 0) {
            System.out.println(Settings.ball + MESSAGE_FOR_BALL + Settings.strike + MESSAGE_FOR_STRIKE);
        } else if (Settings.strike != 0) {
            System.out.println(Settings.strike + MESSAGE_FOR_STRIKE);
        } else if (Settings.ball != 0) {
            System.out.println(Settings.ball + MESSAGE_FOR_BALL);
        }
    }
}
