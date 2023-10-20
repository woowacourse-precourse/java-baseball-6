package baseball.view;

import baseball.domain.Result;


public class ConsolePrint {

    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final String FINISH_INPUT_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String BALL_STRING = "볼";
    private static final String NON_STRING = "낫싱";

    private ConsolePrint() {
    }

    public static void printStart() {
        System.out.println(START_STRING);
    }

    public static void printNumberInput() {
        System.out.print(NUMBER_INPUT_STRING);
    }

    public static void printFinish() {
        System.out.println(FINISH_INPUT_STRING);
    }

    public static void printResult(Result result) {
        if (result.isFinish()) {
            System.out.println(getNoBallString(result));
            return;
        }
        if (result.isNon()) {
            System.out.println(NON_STRING);
            return;
        }
        System.out.println(getBallStrikeString(result));
    }

    private static String getBallStrikeString(Result result) {
        return result.getBall() + BALL_STRING + " " + result.getStrike() + STRIKE_STRING;
    }

    private static String getNoBallString(Result result) {
        return result.getStrike() + STRIKE_STRING;
    }
}
