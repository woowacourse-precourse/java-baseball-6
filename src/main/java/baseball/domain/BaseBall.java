package baseball.domain;


public class BaseBall {
    private final int number;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;

    public BaseBall(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력홰야합니다.");
        }
    }

    public static BaseBall toAnswerBaseBall(int number) {
        return new BaseBall(number);
    }

    public static BaseBall toUserBaseBall(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("3자리의 올바른 숫자 값만을 입력해야합니다.");
        }
        return new BaseBall(Integer.parseInt(input));
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof BaseBall) {
            return this.number == ((BaseBall) object).number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
