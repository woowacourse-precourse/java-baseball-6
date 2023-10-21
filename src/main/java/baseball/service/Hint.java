package baseball.service;

public class Hint {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOT_THING = "낫싱";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";

    public static String makeHint(int ballCount, int strikeCount) {
        StringBuilder hint = new StringBuilder(EMPTY_STRING);

        if (ballCount == 0 && strikeCount == 0) {
            return NOT_THING;
        }
        if (ballCount > 0) {
            hint.append(ballCount).append(BALL).append(SPACE);
        }
        if (strikeCount > 0) {
            hint.append(strikeCount).append(STRIKE);
        }

        return hint.toString().trim();
    }

}
