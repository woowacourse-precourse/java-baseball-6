package baseball.domain;

public class Baseball {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final String ILLEGAL_RANGE = "시스템 내부에서 잘못된 값이 입력되었습니다.";

    private int number;

    public Baseball(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (MINIMUM_NUMBER > number && MAXIMUM_NUMBER < number) {
            throw new IllegalArgumentException(ILLEGAL_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Baseball baseball = (Baseball) o;

        return number == baseball.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Baseball{" + "number=" + number + '}';
    }

}
