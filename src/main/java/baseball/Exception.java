package baseball;

public class Exception {

    public void exception_ExceedLength(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 자릿수가 올바르지 않습니다.");
        }
    }
}