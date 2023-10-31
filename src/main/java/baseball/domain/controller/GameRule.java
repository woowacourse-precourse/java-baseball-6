package baseball.domain.controller;

import baseball.domain.view.output.GameProcessingPrinter;
import java.util.List;

public class GameRule {
    private boolean endGame;

    public boolean gameLogic(List<Integer> attempt, List<Integer> target) {
        BallAndStrikeCalculator ballAndStrikeCalculator = new BallAndStrikeCalculator();

        int[] results = ballAndStrikeCalculator.calculate(attempt, target);
        int ball = results[0];
        int strike = results[1];

        // 결과 로직 호출
        gameResult(ball, strike);

        return endGame;
    }

    private void gameResult(int ball, int strike) {
        // 3 strike 라면
        if (strike == 3) {
            GameProcessingPrinter.printAllStrike();
            endGame = true;
            return;
        }

        endGame = false;

        // 아무것도 맞히지 못했을 경우
        if (ball == 0 && strike == 0) {
            GameProcessingPrinter.printNothing();
            return;
        }

        // 그 외의 결과
        GameProcessingPrinter.printProceeding(ball, strike);
    }
}
