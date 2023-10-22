package baseball.model;

import java.util.Objects;

public class BaseballGameCountsMessage {
    private String message;

    private static final int STRIKE = 0;
    private static final int BALL = 0;

    public BaseballGameCountsMessage(BaseballGameCounts baseballGameCounts) {
        Integer strikeCounts = baseballGameCounts.getCounts().get(STRIKE);
        Integer ballCounts = baseballGameCounts.getCounts().get(BALL);

        if (ballCounts > 0) {
            editMessage(String.format("%d볼 ", ballCounts));
        }
        if (strikeCounts > 0) {
            editMessage(String.format("%d스트라이크", strikeCounts));
        }
    }

    public void printMessage() {
        System.out.println(Objects.requireNonNullElse(message, "낫싱"));
    }

    public void editMessage(String frag) {
        if (message == null) {
            this.message = frag;
        } else {
            this.message = frag + this.message;
        }
    }
}
