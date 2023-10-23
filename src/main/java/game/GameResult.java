package game;

import static baseball.constant.NumberConstants.COUNT_ZERO;

public record GameResult(int strikeCount, int ballCount) {

    public boolean isNothing() {
        return strikeCount == COUNT_ZERO && ballCount == COUNT_ZERO;
    }

}
