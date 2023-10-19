package message;

public class Message {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String INTEGER_INPUT_FROM_USER = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_OR_FINISH = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다!";
    private static final String END_GAME = "게임 종료";

    public static void printIntegerInputFromUserMessage() {
        System.out.print(INTEGER_INPUT_FROM_USER);
    }

    public static void printContinueOrFinishMessage() {
        System.out.println(CONTINUE_OR_FINISH);
    }

    public static void printThreeStrikeMessage() {
        System.out.print(THREE_STRIKE);
        System.out.println(END_GAME);
    }

    public static void printEndGameMessage() {
        System.out.println(END_GAME);
    }

    public static void printHintMessage(int[] score) {
        int strike = score[0];
        int ball = score[1];

        if (hasStrikeAndBall(strike, ball)) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        if (hasStrikeButNoBall(strike, ball)) {
            System.out.println(strike + STRIKE);
        }
        if (hasBallButNoStrike(strike, ball)) {
            System.out.println(ball + BALL);
        }
        if (noStrikeAndBall(strike, ball)) {
            System.out.println(NOTHING);
        }
    }

    private static boolean hasStrikeAndBall(int strike, int ball) {
        return strike > 0 && ball > 0;
    }

    private static boolean hasStrikeButNoBall(int strike, int ball) {
        return strike > 0 && ball == 0;
    }

    private static boolean hasBallButNoStrike(int strike, int ball) {
        return ball > 0 && strike == 0;
    }

    private static boolean noStrikeAndBall(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
