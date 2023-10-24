package baseball.comparePositionsNumber;

import static baseball.print.OutputMessage.outputStrikeBallConsoleMessage;

import java.util.List;
import java.util.Objects;

public class ComparePositions {

    public static Integer comparePositionsNumber(List<Integer> baseballNumber, List<Integer> inputMessageNumber) {
        if (baseballNumber == null || inputMessageNumber == null) {
            return 0;
        }

        Integer strikes = getStrikes(baseballNumber, inputMessageNumber);
        Integer balls = getBalls(baseballNumber, inputMessageNumber) - strikes;
        outputStrikeBallConsoleMessage(strikes, balls);

        return strikes;
    }

    private static Integer getStrikes(List<Integer> baseballNumber, List<Integer> inputMessageNumber) {
        Integer countStrikes = 0;
        for (int index = 0; index < baseballNumber.size(); index++) {
            if (Objects.equals(baseballNumber.get(index), inputMessageNumber.get(index))) {
                countStrikes += 1;
            }
        }
        return countStrikes;
    }

    private static Integer getBalls(List<Integer> baseballNumber, List<Integer> inputMessageNumber) {
        Integer countBalls = 0;
        for (Integer integerItem : inputMessageNumber) {
            if (baseballNumber.contains(integerItem)) {
                countBalls += 1;
            }
        }
        return countBalls;
    }
}
