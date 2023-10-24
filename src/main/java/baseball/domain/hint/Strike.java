package baseball.domain.hint;

public class Strike extends HintItem {

    public Strike(int count) {
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
