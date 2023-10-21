package baseball.exception.view;

public class InputCanNotChangeToIntException extends IllegalArgumentException {

    public InputCanNotChangeToIntException(final String string) {
        super(string + "을(를) 숫자로 변환할 수 없습니다.");
    }
}
