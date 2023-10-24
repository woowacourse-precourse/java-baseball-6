package baseball.util;

import baseball.dto.StrikeBallCount;
import java.util.List;

public class InputCalculator {

    private static final int SELECTION_COUNT = 3;

    public static StrikeBallCount compareComputerBallAndUserInput(int[] computerBall, List<Integer> userInput) {

        StrikeBallCount strikeBallCount = new StrikeBallCount();

        for (int i = 0; i < SELECTION_COUNT; i++) {

            compareComputerBallAndEachBall(computerBall, userInput.get(i), i + 1, strikeBallCount);

        }

        return strikeBallCount;
    }

    public static void compareComputerBallAndEachBall(int[] computerBall, int eachBall, int index,
            StrikeBallCount strikeBallCount) {

        if (computerBall[eachBall] == index) {

            strikeBallCount.increaseStrikeCount();

        } else if (computerBall[eachBall] != 0) {

            strikeBallCount.increaseBallCount();

        }

    }

}
