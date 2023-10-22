package baseball.Exception;

public class InputZeroException extends IllegalArgumentException{
    public InputZeroException() {
        super("1부터 9까지의 숫자만 작성해주세요");
    }
}
