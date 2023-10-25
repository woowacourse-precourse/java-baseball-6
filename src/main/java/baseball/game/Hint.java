package baseball.game;

import java.util.List;

public class Hint {
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;
    private List<Integer> hint;

    public Hint(List<Integer> hint) {
        this.hint = hint;
    }

    public int getBall() {
        return hint.get(BALL_INDEX);
    }

    public int getStrike() {
        return hint.get(STRIKE_INDEX);
    }
}
