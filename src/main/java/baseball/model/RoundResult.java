package baseball.model;

import static baseball.global.Constants.NUMBERS_SIZE;
import static baseball.global.Constants.START_INDEX;

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
        for (int position = START_INDEX; position < NUMBERS_SIZE; position++) {
            int number = userNumber.findNumberByPosition(position);
            if (computerNumber.containsNumber(number)) {
                if (computerNumber.findNumberByPosition(position) == number) {
                    strikeCount++;
                    continue;
                }
                ballCount++;
            }
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