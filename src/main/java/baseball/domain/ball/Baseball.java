package baseball.domain.ball;

public class Baseball {

    private final Number number;
    private final int position;

    public Baseball(Number number, int position) {
        this.number = number;
        this.position = position;
    }

    public boolean isMatch(Baseball otherBaseball) {
        return this.number.isSameNumber(otherBaseball.number) && isSamePosition(otherBaseball.position);
    }

    private boolean isSamePosition(int otherPositon) {
        return this.position == otherPositon;
    }

    public boolean isPartialMatch(Baseball otherBaseball) {
        return this.number.isSameNumber(otherBaseball.number) && isOtherPosition(otherBaseball.position);
    }

    private boolean isOtherPosition(int otherPosition) {
        return this.position != otherPosition;
    }
}
