package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
    public static void printGameResult(GameResult gameResult) {
        System.out.println(gameResult.toString());
    }
}
