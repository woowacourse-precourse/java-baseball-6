package baseball.view;

public class View {

    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String END = "게임 종료";
    private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String USER_INPUT = "숫자를 입력해주세요 : ";
    private static final String AFTER_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String NOTHING_MESSAGE = "낫싱";


    private static final int NOTHING = 0;

    public static void startGame() {
        System.out.println(START);
    }

    public static void endGame() {
        System.out.println(END);
    }

    public static void restartGame() {
        System.out.println(RESTART);
    }

    public static void printUserInput() {
        System.out.print(USER_INPUT);
    }

    public static void printHint(int strike, int ball) {
        if (strike == NOTHING && ball == NOTHING) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (ball != NOTHING) {
            stringBuilder.append(ball + BALL_MESSAGE);
        }
        if (strike != NOTHING) {
            stringBuilder.append(strike + STRIKE_MESSAGE);
        }
        System.out.println(stringBuilder);
    }

    public static void afterAnswer() {
        System.out.println(AFTER_ANSWER);
    }
}
