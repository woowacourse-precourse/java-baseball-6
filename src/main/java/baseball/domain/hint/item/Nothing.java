package baseball.domain.hint.item;

import baseball.domain.GameConstants;

public class Nothing extends HintItem {

    public Nothing(int count) {
        super(count);
        setName(GameConstants.NOTHING_TEXT);
    }

    @Override
    public boolean active() {
        if (getCount() > 0) {
            return false;
        } return true;
    }
}
