package baseball.controller.dto;

public class BaseBallGameDto {

    private final String input;

    public BaseBallGameDto(String input) {
        this.input = input;
        validate();
    }

    public String getInput() {
        return input;
    }

    private void validate() {
        if (isNull() || isEmpty()) {
            throw new IllegalArgumentException("빈 입력을 하지 말아 주세요");
        }
    }

    private boolean isEmpty() {
        return input.isEmpty();
    }

    private boolean isNull() {
        return input == null;
    }
}
