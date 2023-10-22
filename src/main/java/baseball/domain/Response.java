package baseball.domain;

import java.util.List;

public class Response {

    private final int NUMBER_BALLS;
    private boolean answerFlag;
    private int strikeCount;
    private int ballCount;

    public Response(List<Integer> result, final int NUMBER_BALLS) {
        this.NUMBER_BALLS = NUMBER_BALLS;
        if (result.get(0) == NUMBER_BALLS) {
            answerFlag = true;
        }
        strikeCount = result.get(0);
        ballCount = result.get(1);
    }

    public boolean judgeResult() {
        return answerFlag;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}
