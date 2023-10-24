package baseball.domain.hint;

public abstract class HintItem {

    private int count;

    private boolean isActive;

    public HintItem(int count) {
        this.count = count;
        this.isActive = active();
    }

    protected int getCount() {
        return count;
    }


    public abstract boolean active();
}
