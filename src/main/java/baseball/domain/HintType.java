package baseball.domain;

public enum HintType {
    BALL(Constants.BALL_NAME), NOTHING(Constants.NOTHING_STRIKE), STRIKE(Constants.STRIKE_NAME);
    private final String name;

    HintType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static class Constants {
        private static final String STRIKE_NAME = "스트라이크";
        private static final String BALL_NAME = "볼";
        private static final String NOTHING_STRIKE = "낫싱";
    }
}
