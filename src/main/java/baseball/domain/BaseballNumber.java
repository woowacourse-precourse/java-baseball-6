package baseball.domain;

import java.util.Objects;

public class BaseballNumber {

    private static final int BASEBALL_NUMBER_START = 1;
    private static final int BASEBALL_NUMBER_END = 9;
    private final int number;

    BaseballNumber(final int number){
        vaildateRange(number);
        this.number = number;
    }

    private static void vaildateRange(final int value){
        if(value < BASEBALL_NUMBER_START || value > BASEBALL_NUMBER_END) {
            throw new IllegalArgumentException("숫자 범위가 벗어났습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
