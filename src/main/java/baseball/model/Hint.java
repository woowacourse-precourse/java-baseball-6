package baseball.model;

public enum Hint {
    STRIKE("스트라이크", 0),
    BALL("볼", 0),
    NOTHING("낫싱", 0);

    private String value;
    private int count;

    Hint(String value, int count) {
        this.value = value;
        this.count = count;
    }

    public static void addCount(Hint hint) {
        hint.count++;
    }

    public static String getHintByCount() {
        StringBuilder hint = new StringBuilder();
        if (BALL.count == 0 && STRIKE.count == 0) {
            return NOTHING.value;
        }

        if (BALL.count > 0) {
            hint.append(BALL.count).append(BALL.value).append(" ");
        }

        if (STRIKE.count > 0) {
            hint.append(STRIKE.count).append(STRIKE.value);
        }
        return hint.toString();
    }

    public static int getStrikeCount() {
        return STRIKE.count;
    }

    public static void init() {
        STRIKE.count = 0;
        BALL.count = 0;
        NOTHING.count = 0;
    }
}