package baseball;

public class Notification {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String END_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void notifySuccessResult() {
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_MESSAGE);
    }

    public static void notifyFailResult(int[] strikeBallArray) {
        if (strikeBallArray[0] == 0 && strikeBallArray[1] == 0) {
            System.out.println(NOTHING);
        }

        if (strikeBallArray[0] == 0 && strikeBallArray[1] != 0) {
            System.out.println(strikeBallArray[1] + BALL);
        }

        if (strikeBallArray[0] != 0 && strikeBallArray[1] == 0) {
            System.out.println(strikeBallArray[0] + STRIKE);
        }

        if (strikeBallArray[0] != 0 && strikeBallArray[1] != 0) {
            System.out.println(strikeBallArray[1] + BALL + " " + strikeBallArray[0] + STRIKE);
        }
    }

    public static void notifyGameStart() {
        System.out.println(START_MESSAGE);
    }
}
