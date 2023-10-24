package baseball.domain.hint.item;

public class Nothing extends HintItem {

    public Nothing(int count) {
        super(count);
    }

    @Override
    public boolean active() {
        if (getCount() > 0) {
            return false;
        } return true;
    }
}
