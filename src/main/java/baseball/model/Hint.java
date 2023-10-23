package baseball.model;

import baseball.view.HintOutput;
import java.util.List;

public class Hint {

    public static void compareNumber(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < playerNumber.size(); i++) {
            int baseNumber = playerNumber.get(i);
            if (baseNumber == computerNumber.get(i)) {
                strikeCount++;
                continue;
            }
            if (computerNumber.contains(baseNumber)) {
                ballCount++;
            }
        }
        printHintMessage(ballCount, strikeCount);
    }

    private static void printHintMessage(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0) {
            HintOutput.noMatchingNumber();
        }
        if (strikeCount == 0 && ballCount > 0) {
            HintOutput.existBallNumber(ballCount);
        }
        if (strikeCount > 0 && ballCount == 0) {
            HintOutput.existStrikeNumber(strikeCount);
        }
        if (strikeCount > 0 && ballCount > 0) {
            HintOutput.existBallAndStrikeNumber(ballCount, strikeCount);
        }
    }
}
