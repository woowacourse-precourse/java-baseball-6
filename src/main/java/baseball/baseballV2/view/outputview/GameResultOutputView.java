package baseball.baseballV2.view.outputview;

import static baseball.baseballV2.system.util.Util.GAME_RESULT_PATH;

import baseball.baseballV2.model.Result;
import java.util.List;
import java.util.Map;

public class GameResultOutputView implements OutputView {

    public static final int BALL_INDEX = 0;
    public static final int STRIKE_INDEX = 1;
    public static final String BOTH_FORMAT = "%d%s %d%s\n";
    public static final String BALL_FORMAT = "%d%s\n";
    public static final String STRIKE_FORMAT = "%d%s\n";

    @Override
    public void print(Map<String, Object> model) {
        List<Integer> ballAndStrikeCounts = (List<Integer>) model.get(GAME_RESULT_PATH);
        checkBallAndStrike(ballAndStrikeCounts);
    }

    private void checkBallAndStrike(List<Integer> ballAndStrikeCounts) {
        int ballCount = ballAndStrikeCounts.get(BALL_INDEX);
        int strikeCount = ballAndStrikeCounts.get(STRIKE_INDEX);

        if (ballCount > 0 && strikeCount > 0) {
            printBothBallAndStrike(ballCount, strikeCount);
            return;
        }

        if (ballCount > 0) {
            printOnlyBall(ballCount);
            return;
        }

        if (strikeCount > 0) {
            printOnlyStrike(strikeCount);
            return;
        }

        printNothing();
    }

    private void printNothing() {
        System.out.println(Result.NOTHING.getDescription());
    }

    private void printBothBallAndStrike(Integer ballCount, Integer strikeCount) {
        System.out.printf(BOTH_FORMAT, ballCount, Result.BALL.getDescription(),
                strikeCount, Result.STRIKE.getDescription());
    }

    private void printOnlyBall(int ballCount) {
        System.out.printf(BALL_FORMAT, ballCount,
                Result.BALL.getDescription());
    }

    private void printOnlyStrike(int strikeCount) {
        System.out.printf(STRIKE_FORMAT, strikeCount,
                Result.STRIKE.getDescription());
    }
}
