package baseball.view;

public class OutputView {

    private static final String START_GAME_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String GET_USER_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    private static final String END_GAME_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GET_RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public static void printStartGameMsg() {
        System.out.println(START_GAME_MSG);
    }

    public static void printGetUserNumbersMsg() {
        System.out.print(GET_USER_NUMBERS_MSG);
    }

    public static void printEndGameMsg() {
        System.out.println(END_GAME_MSG);
    }

    public static void printGetRestartMsg() {
        System.out.println(GET_RESTART_MSG);
    }

    public static void printBaseballResult(int balls, int strikes) {
        String answer = "";

        if (balls == 0 && strikes == 0) {
            answer += NOTHING;
        }
        if (balls > 0) {
            answer += (balls + BALL);
        }
        if (strikes > 0) {
            answer += (strikes + STRIKE);
        }

        System.out.println(answer);
    }
}
