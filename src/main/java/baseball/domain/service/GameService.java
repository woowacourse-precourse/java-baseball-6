package baseball.domain.service;

import baseball.domain.entity.ScoreBoard;
import baseball.domain.util.calculator.BallAndStrikeCalculator;
import baseball.domain.view.output.GameProcessingPrinter;
import java.util.List;

public class GameService {
    private boolean endGame;

    public boolean gameLogic(List<Integer> attempt, List<Integer> target) {
        BallAndStrikeCalculator ballAndStrikeCalculator = new BallAndStrikeCalculator();

        ScoreBoard scoreBoard = ballAndStrikeCalculator.calculate(attempt, target);
        int ball = scoreBoard.getBall();
        int strike = scoreBoard.getStrike();

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
