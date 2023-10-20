package baseball.view;

public class OutputView {

    private static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUTTING_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String BLANK_SPACE = " ";

    public static void printBaseballGameStartMessage() {
        System.out.println(BASEBALL_GAME_START_MESSAGE);
    }

    public static void printMessageToInputNumbers() {
        System.out.print(INPUTTING_NUMBERS_MESSAGE);
    }

    public static void printNothing() {
        System.out.println(NOTHING);
    }

    public static void printOnlyStrike(int strikeNumbers) {
        System.out.println(strikeNumbers + STRIKE);
    }

    public static void printBallAndStrike(int ballNumbers, int strikeNumbers) {
        System.out.println(ballNumbers + BALL + BLANK_SPACE + strikeNumbers + STRIKE);
    }
}
