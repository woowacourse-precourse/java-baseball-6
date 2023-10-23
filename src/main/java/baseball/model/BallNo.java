package baseball.model;

import java.util.Objects;

public class BallNo {
    private static final int FIRST_NO = 1;
    private static final int END_NO = 9;
    private static final String WRONG_RANGE_OF_NUMBER = "[ERROR] 야구공은 1에서 9사이의 숫자만 가능합니다.";
    private final int number;

    public BallNo(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < FIRST_NO || number > END_NO) {
            throw new IllegalArgumentException(WRONG_RANGE_OF_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNo ballNo = (BallNo) o;
        return number == ballNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
