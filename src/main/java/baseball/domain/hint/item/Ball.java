package baseball.domain.hint.item;

public class Ball extends HintItem {

    public Ball(int count) {
        super(count);
    }

    @Override
    public boolean active() {
        if (getCount() > 0) {
            return true;
        }
        return false;
    }
}
