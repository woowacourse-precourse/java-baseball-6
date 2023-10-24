package baseball.domain.hint.item;

public abstract class HintItem {

    private int count;

    private boolean isActive;

    public HintItem(int count) {
        this.count = count;
        this.isActive = active();
    }

    public abstract boolean active();

    protected int getCount() {
        return count;
    }

    public boolean isActive() {
        return isActive;
    }
}
