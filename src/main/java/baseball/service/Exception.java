package baseball.service;

public class Exception {
    public void validateInputNumber(String number) {
        String exceptionMessage = "";

        if (number.length() != 3) {
            exceptionMessage = "세 자리 수를 입력해 주세요";
        }

        throw new IllegalArgumentException(exceptionMessage);
    }
}
