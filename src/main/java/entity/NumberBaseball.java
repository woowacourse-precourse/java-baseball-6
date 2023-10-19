package entity;

public class NumberBaseball {

    private final String numbers;

    public NumberBaseball(String numbers) {
        this.numbers = numbers;
    }

    public void isValid() {
        if (isNumberLengthThree() && isNumberDuplicate() && isNumber()) {
            return;
        }
        throw new IllegalStateException();
    }

    private boolean isNumber() {
        return numbers.chars()
                .allMatch(Character::isDigit);
    }

    private boolean isNumberLengthThree() {
        return numbers.length() == 3;
    }

    private boolean isNumberDuplicate() {
        char firstNumber = numbers.charAt(0);
        char secondNumber = numbers.charAt(1);
        char thirdNumber = numbers.charAt(2);

        return firstNumber != secondNumber && secondNumber != thirdNumber && firstNumber != thirdNumber;
    }
}
