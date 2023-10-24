package baseball.util;

public class InputValidate {

    public static void validateLength(String[] input) {
        if(input.length != 3) {
            throw new IllegalArgumentException("입력 값은 총 3자리여야 합니다.");
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해야 합니다.");
        }
    }
}
