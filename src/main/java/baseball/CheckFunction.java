package baseball;

public class CheckFunction {
    private String input;

    public CheckFunction(String input) {
        this.input = input; // input이라는 객체를 받아옴.
    }

    public boolean isValid() {
        return (input != null && input.length() == 3 && input.charAt(0) != input.charAt(1) &&
                input.charAt(1) != input.charAt(2) && input.charAt(0) != input.charAt(2) &&
                input.charAt(0) >= '0' && input.charAt(0) <= '9' &&
                input.charAt(1) >= '0' && input.charAt(1) <= '9' &&
                input.charAt(2) >= '0' && input.charAt(2) <= '9');
        // 이 객체가 서로 같으면 false, 같지 않으면 true를 리턴
    }
}
