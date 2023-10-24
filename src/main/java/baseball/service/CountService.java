package baseball.service;

import baseball.validation.NumberValidation;

import java.util.stream.Stream;

import static baseball.constant.Constant.NUMBER_LENGTH;
import static baseball.message.CountMessage.BALL;
import static baseball.message.CountMessage.STRIKE;

public class CountService {
    private int[] number;
    private int ballCount = 0;
    private int strikeCount = 0;

    public CountService(int[] computerNumber) {
        resetCount(computerNumber);
    }

    public void resetCount(int[] computerNumber) {
        this.number = computerNumber;
        strikeCount = 0;
        ballCount = 0;
    }

    public String getResultCount(int[] computerNumber, int[] playerNumber) {
        int ball = getBallCount(computerNumber, playerNumber);
        String ballCount = BALL.toString(ball);

        int strike = getStrikeCount(computerNumber, playerNumber);
        String strikeCount = STRIKE.toString(strike);

        return (ballCount + " " + strikeCount).trim();
    }

    public int getBallCount(int[] computerNumber, int[] playerNumber) {
        this.ballCount = (int) Stream.iterate(0, i -> i + 1).limit(NUMBER_LENGTH)
                .filter(i -> computerNumber[i] != playerNumber[i] && NumberValidation.validateIsInArray(computerNumber,
                        playerNumber[i]))
                .count();
        return ballCount;
    }

    public int getStrikeCount(int[] computerNumber, int[] playerNumber) {
        this.strikeCount = (int) Stream.iterate(0, i -> i + 1).limit(NUMBER_LENGTH)
                .filter(i -> computerNumber[i] == playerNumber[i])
                .count();
        return strikeCount;
    }

    public boolean isNothing() {
        return this.strikeCount == 0 && this.ballCount == 0;
    }
}
