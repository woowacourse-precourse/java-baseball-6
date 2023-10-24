package baseball.exception.consoleView;

public class ConsoleInputBlankException extends IllegalArgumentException {

    public ConsoleInputBlankException() {
        super("입력이 공백이거나 비어있을 수 없습니다. 다시 입력해주세요.");
    }
}
