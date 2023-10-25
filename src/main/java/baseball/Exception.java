package baseball;

public class Exception {
    public void checkInputNumber(String inputNumber) {
        checkNumberLength(inputNumber);
    }
    public void checkNumberLength(String inputNumber) {
        if(inputNumber.length() != 3) {
            throw new IllegalArgumentException("숫자 길이가 3이 아닙니다.");
        }
    }
}
