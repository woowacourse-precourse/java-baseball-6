package baseball.util.exception;

public class numberOutOfRangeException extends IllegalArgumentException{
    private static final String OUT_OF_RANGE_INPUT = "1-9사이의 숫자만 입력해주세요.";

    public numberOutOfRangeException(){
        super(OUT_OF_RANGE_INPUT);
    }
}
