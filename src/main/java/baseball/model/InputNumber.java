package baseball.model;

public class InputNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private final int inputNumber;

    InputNumber(char inputNumber) {
        int number = Character.getNumericValue(inputNumber);
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("각 자리는 1~9사이 숫자만 가능합니다.");
        }
        this.inputNumber = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InputNumber nextNumber = (InputNumber) obj;
        int nextNumberValue = nextNumber.inputNumber;
        return (nextNumberValue == this.inputNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(inputNumber);
    }
}
