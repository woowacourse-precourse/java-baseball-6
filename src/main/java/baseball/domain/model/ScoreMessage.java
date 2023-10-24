package baseball.domain.model;

public enum ScoreMessage {
    NOTHING {
        @Override
        public String formatMessage(int count) {
            return "낫싱";
        }
    },
    BALL {
        @Override
        public String formatMessage(int count) {
            return count + "볼";
        }
    },
    STRIKE {
        @Override
        public String formatMessage(int count) {
            return count + "스트라이크";
        }
    };

    public abstract String formatMessage(int count);
}

