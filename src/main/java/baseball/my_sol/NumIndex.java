package baseball.my_sol;

public class NumIndex {
    private final int ballIndex;

    public NumIndex(int ballIndex) {
        this.ballIndex = ballIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumIndex ballIndex1 = (NumIndex) o;
        return ballIndex == ballIndex1.ballIndex;
    }
}
