package baseball.verifier;

public class ControlNumVerifier implements Verifier {
    @Override
    public void check(String input) throws IllegalArgumentException {
        if(input.equals("1")|| input.equals("2"))
            return;
        throw new IllegalArgumentException("1 또는 2를 입력하지 않았습니다.");
    }
}
