package baseball.domain.game;

public enum BaseballGameResult {
        STRIKE("스트라이크"),
        BALL("볼"),
        NOTING("낫싱");

        private final String value;

        BaseballGameResult(String value) {
                this.value = value;
        }

        @Override
        public String toString() {
                return value;
        }
}
