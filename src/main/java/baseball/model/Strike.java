package baseball.model;

public class Strike extends Judgement {

    private static final String STRIKE_TEXT = "스트라이크";

    public Strike(Integer count) {
        super(count, STRIKE_TEXT);
    }

    public Boolean isFullStrike() {
        return this.count.equals(Computer.NUMBER_DIGIT);
    }
}
