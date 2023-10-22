package baseball.Exception;

public class ReplayInputException extends IllegalArgumentException{
    public ReplayInputException() {
        super("1과 2 중에 선택하여 입력해주세요.");
    }
}
