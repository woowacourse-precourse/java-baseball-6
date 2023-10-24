package baseball.model;

public class BaseballGameCountsMessage {
    private String message;

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    public BaseballGameCountsMessage(BaseballGameCounts baseballGameCounts) {
        Integer ballCounts = baseballGameCounts.getCounts().get(BALL);
        Integer strikeCounts = baseballGameCounts.getCounts().get(STRIKE);

        if (strikeCounts > 0) {
            editMessage(String.format("%d스트라이크", strikeCounts));
        }

        if (ballCounts > 0) {
            editMessage(String.format("%d볼 ", ballCounts));
        }

        if (strikeCounts == 0 && ballCounts == 0) {
            editMessage("낫싱");
        }
    }

    public void editMessage(String frag) {
        if (message == null) {
            this.message = frag;
        } else {
            this.message = frag + this.message;
        }
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
