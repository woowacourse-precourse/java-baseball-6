package baseball.view;

public class ErrorView {

    public void inputNumberLengthError() {
        throw new IllegalArgumentException("입력 값은 3자리여야 합니다.");
    }
    public void validateInputError() {
        throw new IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다.");
    }
    public void validateInputModeError() {throw new IllegalArgumentException("1 또는 2를 입력해여 합니다.");}
}
