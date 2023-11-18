package baseball.model;

import java.util.stream.IntStream;

import static baseball.utils.Constants.NUMBERS_SIZE;
import static baseball.utils.Constants.START_INDEX;

public class RoundResult {
    private int ballCount = 0;
    private int strikeCount = 0;

    private RoundResult(ComputerNumber computerNumber, UserNumber userNumber) {
        processRound(computerNumber, userNumber);
    }

    public static RoundResult create(ComputerNumber computerNumber, UserNumber userNumber) {
        return new RoundResult(computerNumber, userNumber);
    }

    private void processRound(ComputerNumber computerNumber, UserNumber userNumber) {
        IntStream.range(START_INDEX, NUMBERS_SIZE).forEach(position -> {
            int number = userNumber.findNumberByPosition(position);
            calculateBallAndStrike(computerNumber, number, position);
        });

    }

    private void calculateBallAndStrike(ComputerNumber computerNumber, int number, int position) {
        if (computerNumber.containsNumber(number)) {
            if (computerNumber.findNumberByPosition(position) == number) {
                strikeCount++;
            }
            ballCount++;
        }
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean needsNextRound() {
        return strikeCount != 3;
    }

    public int provideBallCount() {
        return ballCount;
    }

    public int provideStrikeCount() {
        return strikeCount;
    }
}