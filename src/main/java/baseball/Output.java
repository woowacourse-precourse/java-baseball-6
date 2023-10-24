package baseball;

public class Output {

    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String COMPLETED_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String BLANK = " ";

    public static void startCommand() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printBallAndStrike(int ball, int strike) {
        System.out.println(ball + BALL + BLANK + strike + STRIKE);
    }

    public static void printOnlyStrike(int strike) {
        System.out.println(strike + STRIKE);
    }

    public static void printOnlyBall(int ball) {
        System.out.println(ball + BALL);
    }

    public static void printNothing() {
        System.out.println(NOTHING);
    }

    public static void printFinishGame() {
        System.out.println(COMPLETED_GAME);
    }
}
