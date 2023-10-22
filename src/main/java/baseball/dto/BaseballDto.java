package baseball.dto;

import baseball.validator.InputValidator;
import java.util.regex.Pattern;

public record BaseballDto(String baseball) {

    public BaseballDto {
        InputValidator.validate(baseball);
        Validator.validate(baseball);
    }

    private static class Validator {

        private static final Pattern BASEBALL_PATTERN = Pattern.compile("^(?!.*(.).*\\1)[1-9]{3}$");
        private static final String INVALID_MESSAGE = "1 이상 9 이하 값을 가진 서로 다른 세 자리 숫자여야 합니다.";

        public static void validate(String baseball) {
            if (!BASEBALL_PATTERN.matcher(baseball).matches()) {
                throw new IllegalArgumentException(INVALID_MESSAGE);
            }
        }
    }
}
