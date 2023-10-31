package baseball.domain.service;

import baseball.domain.config.GameConfig;
import baseball.domain.entity.ScoreBoard;
import baseball.domain.util.calculator.BallAndStrikeCalculator;
import baseball.domain.view.output.GameProcessingPrinter;
import java.util.List;

public class GameService {
    private static final int BASEBALL_SIZE = GameConfig.BASEBALL_SIZE;

    public ScoreBoard gameLogic(List<Integer> attempt, List<Integer> target) {
        BallAndStrikeCalculator ballAndStrikeCalculator = new BallAndStrikeCalculator();
        ScoreBoard scoreBoard = ballAndStrikeCalculator.calculate(attempt, target);
        gameResult(scoreBoard.getBall(), scoreBoard.getStrike());

        return scoreBoard;
    }

    private void gameResult(int ball, int strike) {
        // All strike인 경우
        if (strike == BASEBALL_SIZE) {
            GameProcessingPrinter.printAllStrike();
            return;
        }

        // 아무것도 맞히지 못했을 경우
        if (ball == 0 && strike == 0) {
            GameProcessingPrinter.printNothing();
            return;
        }

        // 그 외의 결과
        GameProcessingPrinter.printProceeding(ball, strike);
    }
}
