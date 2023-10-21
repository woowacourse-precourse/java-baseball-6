package baseball.exception.view;

public class InputBlankException extends IllegalArgumentException {

    public InputBlankException() {
        super("입력이 공백이거나 비어있을 수 없습니다. 다시 입력해주세요.");
    }
}
