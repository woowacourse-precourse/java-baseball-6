package baseball.ball;

public class Index {
    public static final int MINIMUM_INDEX = 0;
    public static final int MAXIMUM_INDEX = 2;
    private final int index;

    public Index(int index) {
        validateRange(index);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public boolean isEqualTo(Index otherIndex) {
        return index == otherIndex.getIndex();
    }

    private void validateRange(int index) {
        if (index < MINIMUM_INDEX || MAXIMUM_INDEX < index) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위를 벗어났습니다.");
        }
    }
}
