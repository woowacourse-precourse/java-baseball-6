package baseball.dto;

import java.util.regex.Pattern;

public record ReplayDto(String replay) {

    public ReplayDto {
        Validator.validate(replay);
    }

    private static class Validator {

        private static final Pattern REPLAY_PATTERN = Pattern.compile("[12]");
        private static final String INVALID_MESSAGE = "1 또는 2여야 합니다.";

        public static void validate(String replay) {
            if (!REPLAY_PATTERN.matcher(replay).matches()) {
                throw new IllegalArgumentException(INVALID_MESSAGE);
            }
        }
    }
}
