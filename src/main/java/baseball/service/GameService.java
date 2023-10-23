package baseball.service;

import baseball.domain.GameResult;
import baseball.view.OutputView;
import java.util.List;

public class GameService {

    public GameService() {
    }

    public boolean isGameOver(GameResult gameResult) {
        if (gameResult.getStrike() == 3) {
            OutputView.printGameEnd();
            return true;
        }
        return false;
    }

    public GameResult checkResult(List<Integer> numbers, List<Integer> computerNumbers) {
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