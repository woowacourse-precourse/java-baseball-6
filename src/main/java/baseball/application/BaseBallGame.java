package baseball.application;

import baseball.domain.BaseBallNumberList;
import java.util.stream.Stream;

public class BaseBallGame {

    private final BaseBallNumberList computer;
    private final GameManager gameManager;

    public BaseBallGame(BaseBallNumberList computer, GameManager gameManager) {
        this.computer = computer;
        this.gameManager = gameManager;
    }

    public BaseBallResult play(BaseBallNumberList playerInput) {
        int strike = getStrike(playerInput);
        int ball = getBall(strike,playerInput);

        if (isExit(strike)) {
            gameManager.exit();
        }
        return new BaseBallResult(strike, ball);
    }

    private boolean isExit(int strike) {
        return strike == computer.size();
    }

    private int getBall(int strike, BaseBallNumberList playerInput) {
        int count = computer.countSameNumber(playerInput);
        return count-strike;
    }

    private int getStrike(BaseBallNumberList playerInput) {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1).limit(computer.size());
        return (int)stream.filter(index->computer.equalAt(index,playerInput)).count();
    }
}
