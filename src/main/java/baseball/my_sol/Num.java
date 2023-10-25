package baseball.my_sol;

public class Num {
    private final NumIndex ballIndex;
    private final Number ballNumber;

    public Num(int index, int ballNumber) {
        this.ballIndex = new NumIndex(index);
        this.ballNumber = new Number(ballNumber);
    }

    public NumStatus compareTo(Num compareBall) {
        if (this.equals(compareBall)) {
            return NumStatus.STRIKE;
        }
        if (this.ballNumber.equals(compareBall.ballNumber)) {
            return NumStatus.BALL;
        }
        return NumStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num ball = (Num) o;
        return ballIndex.equals(ball.ballIndex) && ballNumber.equals(ball.ballNumber);
    }
}
