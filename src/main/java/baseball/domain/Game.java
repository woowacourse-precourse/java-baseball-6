package baseball.domain;

import java.util.List;

import static baseball.service.GameResultCalculator.caculateGameResult;

public class Game {
    private final List<Integer> computerNumbers;
    private boolean isUserWin = false;

    public Game(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
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
