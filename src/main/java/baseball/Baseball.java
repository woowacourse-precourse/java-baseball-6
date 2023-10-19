package baseball;

import static baseball.BaseballConstants.*;

public class Baseball {

    public static final int INIT_COUNT = 0;
    private int ballCount;
    private int strikeCount;


    public Baseball() {
        this.ballCount = INIT_COUNT;
        this.strikeCount = INIT_COUNT;
    }

    public void incrementBallCount() {
        ballCount++;
    }
    public void incrementStrikeCount() {
        strikeCount++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ballCount != INIT_COUNT) {
            sb.append(ballCount + BALL + BLANK);
        }
        if (strikeCount != INIT_COUNT) {
            sb.append(strikeCount + STRIKE);
        }
        if (sb.isEmpty()) {
            sb.append(NOTHING);
        }
        return sb.toString().trim();
    }
}
