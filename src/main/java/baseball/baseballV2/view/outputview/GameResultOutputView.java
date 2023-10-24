package baseball.baseballV2.view.outputview;

import baseball.baseballV2.model.Result;
import java.util.List;
import java.util.Map;

public class GameResultOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        List<Integer> ballAndStrikeCounts = (List<Integer>) model.get("gameResult");
        checkBallAndStrike(ballAndStrikeCounts);
    }

    private void checkBallAndStrike(List<Integer> ballAndStrikeCounts) {
        int ballCount = ballAndStrikeCounts.get(0);
        int strikeCount = ballAndStrikeCounts.get(1);

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
        System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
    }


    private void printOnlyBall(int ballCount) {
        System.out.printf("%d볼\n", ballCount);
    }

    private void printOnlyStrike(int strikeCount) {
        System.out.printf("%d스트라이크\n", strikeCount);
    }
}
