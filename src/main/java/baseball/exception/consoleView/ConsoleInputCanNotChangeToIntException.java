package baseball.exception.consoleView;

public class ConsoleInputCanNotChangeToIntException extends IllegalArgumentException {

    public ConsoleInputCanNotChangeToIntException(final String string) {
        super(string + "을(를) 숫자로 변환할 수 없습니다.");
    }
}
