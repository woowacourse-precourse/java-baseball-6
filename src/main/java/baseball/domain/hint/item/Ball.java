package baseball.domain.hint.item;

import baseball.domain.GameConstants;

public class Ball extends HintItem {

    public Ball(int count) {
        super(count);
        setName(GameConstants.BALL_TEXT);
    }

    @Override
    public boolean active() {
        if (getCount() > 0) {
            return true;
        }
        return false;
    }
}
