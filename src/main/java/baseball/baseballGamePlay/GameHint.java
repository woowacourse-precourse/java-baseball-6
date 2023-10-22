package baseball.baseballGamePlay;

import baseball.comparePositionsNumber.ComparePositions;
import baseball.print.InputMessage;
import java.util.List;

public class GameHint {
    private final InputMessage inputMessage = new InputMessage();
    private final ComparePositions comparePositions = new ComparePositions();
    private final Integer ZERO = 0;
    private final Integer THREE_STRIKE = 3;

    public Integer baseballGameHint(List<Integer> baseballNumber) {
        Integer numberStrikeResults = ZERO;
        while (numberStrikeResults < THREE_STRIKE) {
            List<Integer> inputMessageNumber = inputMessage.inputMessageNumber();
            numberStrikeResults = comparePositions.comparePositionsNumber(baseballNumber, inputMessageNumber);
        }

        return numberStrikeResults;
    }
}
