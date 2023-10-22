package validate;

public class RestartInputValidator {
    public void validator(String input) throws IllegalArgumentException{
        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException("해당 입력에서는 1(재시작) 혹은 2(종료)만 입력 가능합니다.");
        }
    }
}
