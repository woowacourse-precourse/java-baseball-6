package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.MatchResult;
import baseball.view.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GameController {

    public void run() {
        OutputView.printStartGame();
        List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        recursiveGame(computerNumbers);
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
            return true;
        }
        return false;
    }

    private GameResult checkResult(List<Integer> numbers, List<Integer> computerNumbers) {
        for (Integer a :
                computerNumbers) {
            System.out.println(a);
        }

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < numbers.size(); i++) {
            Integer player = numbers.get(i);
            for (int j = 0; j < computerNumbers.size(); j++) {
                Integer computer = computerNumbers.get(j);
                if (i == j && player.equals(computer)){
                    strike++;
                }
                if (i != j && player.equals(computer)){
                    ball++;
                }
            }
        }

        return new GameResult(strike, ball);
    }

}
