package baseball.game;

import static baseball.constant.NumberConstants.COUNT_ZERO;
import static baseball.constant.NumberConstants.GAME_END_CONDITION;
import static baseball.game.GameOutput.printCorrectBallCount;
import static baseball.game.GameOutput.printCorrectStrikeCount;
import static baseball.game.GameOutput.printStrikeThree;

public record GameResult(int strikeCount, int ballCount) {

    public boolean isNothing() {
        return strikeCount == COUNT_ZERO && ballCount == COUNT_ZERO;
    }

    public void callStrikeThree() {
        printStrikeThree(strikeCount);
    }

    public boolean strikeCountIsNotGameEndCondition() {
        return strikeCount != GAME_END_CONDITION;
    }

    public boolean hasBalls() {
        return ballCount > COUNT_ZERO;
    }

    public boolean hasStrikes() {
        return strikeCount > COUNT_ZERO;
    }

    public void callBallCount() {
        printCorrectBallCount(ballCount);
    }

    public void callStrikeCount() {
        printCorrectStrikeCount(strikeCount);
    }

}
