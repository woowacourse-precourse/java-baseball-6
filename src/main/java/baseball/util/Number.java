package baseball.util;

public record Number(int number) {
    public void checkValidate() {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("Invalid number " + number);
        }
    }
}
