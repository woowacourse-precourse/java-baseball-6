package baseball;

public class Validate {
    private String number;

    Validate() {

    }

    public void validateInput(String number) { // 입력받은 숫자가 이상하다면 예외를 던지는 메소드
        this.number = number;
        if (number.length() != 3 || checkZeroValue() == false) {
            throw new IllegalArgumentException();
        }
    }

    boolean checkZeroValue() { // 입력받은 숫자에 이상한 값이 있는지 검사하는 메소드
        for (int i = 0; i < this.number.length(); i++) {
            if (number.charAt(i) <= '0' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
