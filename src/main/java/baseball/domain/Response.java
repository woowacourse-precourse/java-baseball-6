package baseball.domain;

import java.util.List;

public class Response {

    private final int NUMBER_BALLS;
    private boolean isRetry;
    private int strikeCount;
    private int ballCount;

    public Response(List<Integer> result, final int NUMBER_BALLS) {
        this.NUMBER_BALLS = NUMBER_BALLS;
        isRetry = true;
        if (result.get(0) == NUMBER_BALLS) {
            isRetry = false;
        }
        strikeCount = result.get(0);
        ballCount = result.get(1);
    }

    public boolean isWrongAnswer() {
        return isRetry;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}
