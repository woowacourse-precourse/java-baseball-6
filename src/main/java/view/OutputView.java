package view;

public class OutputView {
    static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static String INPUT_THREE_DIGITS_MESSAGE = "숫자를 입력해주세요 : ";
    static String BALL = "볼";
    static String STRIKE = "스트라이크";
    static String NOTHING = "낫싱";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputThreeDigits() {
        System.out.print(INPUT_THREE_DIGITS_MESSAGE);
    }

    public static void printResult(int ballCount, int strikeCount) {
        StringBuilder stringBuilder = new StringBuilder();
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append(BALL).append(' ');
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append(STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            stringBuilder.append(NOTHING);
        }
        System.out.println(stringBuilder);
    }
}
