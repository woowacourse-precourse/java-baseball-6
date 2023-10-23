package baseball.model;

public class Strike {
    private int strikeCount;

    public Strike() {
        this.strikeCount = 0;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }


    public boolean isThreeStrike() {
        return this.strikeCount == 3;
    }

    public boolean isZeroStrike() {
        return this.strikeCount == 0;
    }

    public String getComment() {
        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }
        return Constant.ZERO_COUNT;
    }
}
