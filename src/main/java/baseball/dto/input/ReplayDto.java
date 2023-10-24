package baseball.dto.input;

import baseball.constants.GameStatus;
import baseball.validator.InputValidator;

public record ReplayDto(String replay) {

    public ReplayDto {
        InputValidator.validate(replay);
        Validator.validate(replay);
    }

    private static class Validator {

        private static final String INVALID_INPUT_MESSAGE = "1 또는 2를 입력해주세요.";

        public static void validate(String replay) {
            if (!GameStatus.contains(replay)) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
    }
}
