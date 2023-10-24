package baseball.util.exception;

public class inputOutOfRangeException extends IllegalArgumentException{
    private static final String OUT_OF_RANGE_INPUT = "1-9사이의 숫자만 입력해주세요.";

    public inputOutOfRangeException(){
        super(OUT_OF_RANGE_INPUT);
    }
}
