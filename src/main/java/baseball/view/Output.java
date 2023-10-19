package baseball.view;

public class Output {
    private static final String NO_BALL_NO_STRIKE = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printCorrectAnswer() {
        System.out.println(3+STRIKE);
        System.out.println(FINISH_MESSAGE);
    }

    public static void printBallStrike(int ball, int strike) {
        System.out.println(ball + BALL + " " + strike + STRIKE);
    }

    public static void printBall(int ball) {
        System.out.println(ball + BALL);
    }

    public static void printStrike(int strike) {
        System.out.println(strike + STRIKE);
    }

    public static void printNothing() {
        System.out.println(NO_BALL_NO_STRIKE);
    }
}
