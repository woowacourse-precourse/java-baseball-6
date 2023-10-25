package baseball.view;


public class OutputView {
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printGameEndMessage(int strike) {
        System.out.println(strike + STRIKE_MESSAGE);
        System.out.println(EXIT_MESSAGE);
        System.out.println(CONTINUE_MESSAGE);
    }

    public static void printStartingMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printBallMessage(int ball) {
        System.out.println(ball + BALL_MESSAGE);
    }

    public static void printStrikeMessage(int strike) {
        System.out.println(strike + STRIKE_MESSAGE);
    }

    public static void printStrikeAndBallMessage(int ball, int strike) {
        System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
    }

}
