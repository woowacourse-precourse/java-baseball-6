package baseball;

public class Validate {
    private final Integer number;

    public Validate(int number) {
        validateRange(number);

        this.number = number;
    }

    public Validate(char ch) {
        this(Integer.parseInt(String.valueOf(ch)));
    }

    private void validateRange(int number) {
        if (number < 1 || 9 < number) {
            throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Validate validate = (Validate) obj;

        return this.number.equals(validate.number);
    }

    @Override
    public int hashCode() {
        if (number == null) {
            return 0;
        }
        return number.hashCode();
    }

    @Override
    public String toString() {
        return this.number.toString();
    }
}
