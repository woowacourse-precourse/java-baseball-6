package baseball.domain.hint.item;

import baseball.domain.GameConstants;

public class Strike extends HintItem {

    public Strike(int count) {
        super(count);
        setName(GameConstants.STRIKE_TEXT);
    }

    @Override
    public boolean active() {
        if (getCount() > 0) {
            return true;
        }
        return false;
    }
}
