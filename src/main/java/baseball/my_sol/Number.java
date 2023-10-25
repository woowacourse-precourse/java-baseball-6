package baseball.my_sol;

public class Number {
    private final int ballNumber;

    public Number(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return ballNumber == that.ballNumber;
    }
}
