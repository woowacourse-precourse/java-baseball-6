package baseball.domain.hint.item;

public abstract class HintItem {

    private int count;

    private boolean isActive;

    private String name;

    public HintItem(int count) {
        this.count = count;
        this.isActive = active();
    }

    public abstract boolean active();

    public int getCount() {
        return count;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
