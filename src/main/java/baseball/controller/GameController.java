package baseball.controller;

import baseball.domain.GameResult;
import baseball.domain.RandomNumberCreator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    public void run() {
        OutputView.printStartGame();
        List<Integer> computerNumbers = RandomNumberCreator.createRandomNumber();
        recursiveGame(computerNumbers);
        OutputView.printInputRestartGame();
        // 게임 재시작 여부 묻기
        if (InputView.inputRestartGame() == 1) {
            run();
        }
    }

    private void recursiveGame(List<Integer> computerNumbers) {
        OutputView.printInputNumber();
        List<Integer> numbers = InputView.inputNumber();
        GameResult gameResult = checkResult(numbers, computerNumbers);
        OutputView.printGameResult(gameResult);

        if (isGameOver(gameResult)) {
            return;
        }

        recursiveGame(computerNumbers);
    }

    private boolean isGameOver(GameResult gameResult) {
        if (gameResult.getStrike() == 3) {
            OutputView.printGameEnd();
            return true;
        }
        return false;
    }

    private GameResult checkResult(List<Integer> numbers, List<Integer> computerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < numbers.size(); i++) {
            Integer player = numbers.get(i);
            for (int j = 0; j < computerNumbers.size(); j++) {
                Integer computer = computerNumbers.get(j);
                if (i == j && player.equals(computer)) {
                    strike++;
                }
                if (i != j && player.equals(computer)) {
                    ball++;
                }
            }
        }

        return new GameResult(strike, ball);
    }
}
