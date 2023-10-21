package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.NumericComparator;

public class BaseballGameController {
    private Computer computer;
    private Player player;
    private final NumericComparator comparator;

    public BaseballGameController() {
        this.computer = new Computer();
        this.comparator = new NumericComparator();
        this.player = new Player();
    }

    public boolean isStrikeAnswer() {
        return comparator.getStrikeCount() != 0 && comparator.getBallCount() == 0;
    }

    public boolean isBallAnswer() {
        return comparator.getStrikeCount() == 0 && comparator.getBallCount() != 0;
    }

    public boolean isStrikeAndBallAnswer() {
        return comparator.getStrikeCount() != 0 && comparator.getBallCount() != 0;
    }

    public boolean isCorrectAnswer() {
        return comparator.getStrikeCount() == 3;
    }


}
