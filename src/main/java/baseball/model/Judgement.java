package baseball.model;

public abstract class Judgement {

    private final String text;

    protected Integer count;

    public Judgement(Integer count, String text) {
        this.count = count;
        this.text = text;
    }

    public Boolean isExist() {
        return count > 0;
    }

    @Override
    public String toString() {
        if (isExist()) {
            return String.format("%d%s", count, text);
        }
        return "";
    }
}
