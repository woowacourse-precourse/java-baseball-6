package baseball.domain.model;


public enum ScoreMessage {
    NOTHING(count -> "낫싱"),
    BALL(count -> count + "볼"),
    STRIKE(count -> count + "스트라이크");

    private final MessageFormatter formatter;

    ScoreMessage(MessageFormatter formatter) {
        this.formatter = formatter;
    }

    public String formatMessage(int count) {
        return formatter.format(count);
    }
}

