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

    public boolean isCorrectAnswer() {
        return comparator.getStrikeCount() == 3;
    }


}
