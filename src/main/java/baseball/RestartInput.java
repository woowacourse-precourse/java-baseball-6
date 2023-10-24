package baseball;

public class RestartInput {
    private final String restartInput;

    RestartInput(String restartInput) {
        validateOneOrTwo(restartInput);
        this.restartInput = restartInput;
    }

    public boolean isOne() {
        return restartInput.equals("1");
    }

    public boolean isTwo() {
        return restartInput.equals("2");
    }

    private void validateOneOrTwo(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1 혹은 2를 입력하세요.");
        }
    }
}
