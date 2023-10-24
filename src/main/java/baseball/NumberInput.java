package baseball;

public class NumberInput {
    private final String numberInput;

    NumberInput(String numberInput) {
        validateUserInputSize(numberInput);
        this.numberInput = numberInput;
    }

    public void validateUserInputSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    public Numbers getNumbers() {
        Numbers numbers = new Numbers();
        for (int i = 0; i < 3; i++) {
            numbers.addNumber(new Number(numberInput.charAt(i) - '0'));
        }
        return numbers;
    }

    public int getNumberByIndex(int index) {
        return numberInput.charAt(index) - '0';
    }
}
