package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import java.util.List;

public class GameService {
    public GameResult checkGuessNumbers(List<Integer> playerNums, Computer computer) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < playerNums.size(); i++) {
            int comparisonNumber = playerNums.get(i);

            // 같은 수이면서 같은 자리인지 검사
            if (computer.isSameNumber(comparisonNumber, i)) {
                gameResult.increaseStrikeCount();

                continue;
            }

            // 같은 수가 있는지 검사
            if (computer.isContainNumber(comparisonNumber)) {
                gameResult.increaseBallCount();
            }
        }

        return gameResult;
    }
}
