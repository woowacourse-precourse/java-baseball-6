package baseball.domain.Hint;

public abstract class HintItem {

    private int count;

    private boolean isActive;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
