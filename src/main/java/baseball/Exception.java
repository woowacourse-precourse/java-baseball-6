package baseball;

public class Exception {

    public void Exception_PlayerNumberLength(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력된 숫자의 자릿수가 올바르지 않습니다.");
        }
    }

    public void Exception_ReplayNumber(String inputNumber) {
        if (!inputNumber.equals("1") && !inputNumber.equals("2")) {
            throw new IllegalArgumentException("입력된 값이 올바르지 않습니다.");
        }
    }
}