package baseball.domain;

public enum Score {

    STRIKE("스트라이크"),
    BALL("볼"),
    ;

    private static final String NO_HINT = "낫싱";
    private static final String DELIMITER = " ";

    private final String symbol;
    private int count;

    Score(String symbol) {
        this.symbol = symbol;
    }

    public static void initialize() {
        STRIKE.count = 0;
        BALL.count = 0;
    }

    public static String getResultMessage() {
        if (isNothing()) {
            return NO_HINT;
        }

        return parseResultMessage();
    }

    public static boolean isWin() {
        return Score.STRIKE.count == Answer.SIZE;
    }

    private static String parseResultMessage() {
        return String.join(DELIMITER, BALL.summary(), STRIKE.summary()).trim();
    }

    private static boolean isNothing() {
        return BALL.count == 0 && STRIKE.count == 0;
    }

    public void addCount() {
        this.count += 1;
    }

    public String summary() {
        if (isExist()) {
            return count + symbol;
        }
        return "";
    }

    private boolean isExist() {
        return count != 0;
    }
}
