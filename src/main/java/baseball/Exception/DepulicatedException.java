package baseball.Exception;

public class DepulicatedException extends IllegalArgumentException{
    public DepulicatedException() {
        super("숫자를 중복 없이 입력해주세요.");
    }
}
