package baseball;

public class InputNumberException extends IllegalArgumentException{

    public InputNumberException() {
        super("잘못된 값을 입력하셨습니다.");
    }
    public InputNumberException(String message) {
        super(message);
    }
}
