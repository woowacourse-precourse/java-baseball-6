package baseball.view;

public class OutputView {

    private static final String NOTHING = "0";
    private static final int BALL = 0;
    private static final int STRIKE = 1;

    public OutputView(String[] result) {
        if (!result[BALL].equals(NOTHING) && result[STRIKE].equals(NOTHING)) printOnlyBallCountMessage(result[BALL]);
        if (result[BALL].equals(NOTHING)&&!result[STRIKE].equals(NOTHING)) printOnlyStrikeCountMessage(result[STRIKE]);
        if (!result[BALL].equals(NOTHING) && !result[STRIKE].equals(NOTHING)) printBallAndStrikeCountMessage(result[BALL], result[STRIKE]);
        if (result[BALL].equals(NOTHING) && result[STRIKE].equals(NOTHING)) printNothingMessage();
    }


    public static void printGameInitMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printOnlyBallCountMessage(String ball) {
        System.out.println(ball + "볼 ");
    }

    public static void printOnlyStrikeCountMessage(String strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void printBallAndStrikeCountMessage(String ball, String strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }


    public static void printNothingMessage() {
        System.out.println("낫싱");
    }

    public static void printAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
