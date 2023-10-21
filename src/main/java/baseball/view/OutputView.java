package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputUserNumberMessage() {
        System.out.print(INPUT_USER_NUMBER_MESSAGE);
    }

    public static void printOneGameResult(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL + SPACE + strike + STRIKE);
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + BALL);
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        }
        if(strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        }

    }
}
