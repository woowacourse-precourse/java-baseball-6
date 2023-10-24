package baseball;

import static baseball.GameClient.BALL_LENGTH;

import baseball.slot.BaseballNumbersSlot;
import java.util.stream.IntStream;

public class Referee {
    public BallCount calculateBallCount(BaseballNumbersSlot playerNumbers, BaseballNumbersSlot answerNumbers) {
        int strikeCount = (int) IntStream.range(0, BALL_LENGTH)
                .filter(idx -> playerNumbers.get(idx) == answerNumbers.get(idx))
                .count();
        int ballCount = (int) IntStream.range(0, BALL_LENGTH)
                .filter(idx -> playerNumbers.get(idx) != answerNumbers.get(idx) &&
                                        answerNumbers.contains(playerNumbers.get(idx)))
                .count();
        return new BallCount(strikeCount, ballCount);
    }
}
