package baseball.game;

public enum GameHintType {
    STRIKE("스트라이크") {
        @Override
        public String format(int count) {
            return count > 0 ? count + "스트라이크" : "";
        }
    },
    BALL("볼") {
        @Override
        public String format(int count) {
            return count > 0 ? count + "볼" : "";
        }
    },
    NOTHING("낫싱") {
        @Override
        public String format(int count) {
            return "낫싱";
        }
    };

    private final String label;

    GameHintType(String label) {
        this.label = label;
    }

    public abstract String format(int count);
}
