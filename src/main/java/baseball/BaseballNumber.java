package baseball;

public class BaseballNumber {
    final int MIN_NUMBER = 1;
    final int MAX_NUMBER = 9;
    int number;

    BaseballNumber(int number) {
        validate(number);
        this.number = number;
    }

    BaseballNumber(String str) {
        int number = Integer.parseInt(str);
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        return (this.number == ((BaseballNumber) obj).number);
    }
}
