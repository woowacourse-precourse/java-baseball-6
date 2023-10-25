package baseball.application;

import baseball.manager.GameManager;
import baseball.domain.BaseBallNumberList;
import java.util.stream.Stream;

public class BaseBallGame implements GameUseCase {

    private final BaseBallNumberList computer;
    private final GameManager gameManager;

    public BaseBallGame(BaseBallNumberList computer, GameManager gameManager) {
        this.computer = computer;
        this.gameManager = gameManager;
    }

    @Override
    public BaseBallResult umpire(NumericString playerInput) {
        BaseBallNumberList playerBaseBallNumberList = new BaseBallNumberList(playerInput.toList());

        int strike = getStrike(playerBaseBallNumberList);
        int ball = getBall(strike, playerBaseBallNumberList);

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
        return count - strike;
    }

    private int getStrike(BaseBallNumberList playerInput) {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1).limit(computer.size());
        return (int) stream.filter(index -> computer.equalAt(index, playerInput)).count();
    }
}
