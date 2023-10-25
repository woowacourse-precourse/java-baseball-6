package baseball.entity;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final int strikeNumber;
    private final int ballNumber;

    public Result(int strikeNumber, int ballNumber) {
        this.strikeNumber = strikeNumber;
        this.ballNumber = ballNumber;
    }

    @Override
    public String toString() {
        List<String> messages = new ArrayList<>();
        getBallNumberMessage(messages);
        getStrikeNumberMessage(messages);
        checkNothing(messages);

        return String.join(" ", messages);
    }

    private void checkNothing(List<String> messages) {
        if (ballNumber == 0 && strikeNumber == 0) {
            messages.add("낫싱");
        }
    }

    private void getStrikeNumberMessage(List<String> messages) {
        if (strikeNumber != 0) {
            messages.add(strikeNumber + "스트라이크");
        }
    }

    private void getBallNumberMessage(List<String> messages) {
        if (ballNumber != 0) {
            messages.add(ballNumber + "볼");
        }
    }

    public boolean isAllCorrect() {
        return strikeNumber == 3;
    }
}
