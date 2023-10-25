package baseball.console;

public class Output {
    private static final String BALL_MESSAGE = "%d볼\n";
    private static final String STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String ANSWER_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final int REQUIRED_NUMBERS_TO_MATCH = 3;


    public static void print(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            printNothingMessage();
        } else if (ball == 0) {
            printStrikeMessage(strike);
        } else if (strike == 0) {
            printBallMessage(ball);
        } else {
            printBallAndStirkeMessage(ball, strike);
        }
    }

    public static void printBallMessage(int ball) {
        System.out.printf(BALL_MESSAGE, ball);
    }

    public static void printStrikeMessage(int strike) {
        System.out.printf(STRIKE_MESSAGE, strike);
    }

    public static void printBallAndStirkeMessage(int ball, int strike) {
        System.out.printf(BALL_AND_STRIKE_MESSAGE, ball, strike);
    }

    public static void printNothingMessage() {
        System.out.printf(NOTHING_MESSAGE);
    }

    public static void printAnswerMessage() {
        System.out.printf(ANSWER_MESSAGE, REQUIRED_NUMBERS_TO_MATCH);
    }
}