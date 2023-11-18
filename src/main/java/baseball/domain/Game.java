package baseball.domain;

import java.util.List;

import static baseball.service.GameResultCalculator.*;
import static baseball.service.NumberGenerator.*;

public class Game {
    private final List<Integer> computerNumbers;
    private boolean isUserWin = false;

    public Game() {
        this.computerNumbers = pickNumbersInRangeWithoutDuplicates(1,9, 3);
    }

    public GameResult makeGameResult(List<Integer> userNumbers) {
        GameResult gameResult = caculateGameResult(computerNumbers, userNumbers);

        if (gameResult.equals(new GameResult(0, 3, 0))) {
            isUserWin = true;
        }

        return gameResult;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public boolean isUserWin() {
        return isUserWin;
    }

}
