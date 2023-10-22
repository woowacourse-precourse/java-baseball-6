package baseball.model;

import java.util.Objects;

public class BaseballGameCountsMessage {
    private String message;


    public void showCounts() {
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
