package baseball.dto;

import baseball.constants.InputPattern;
import baseball.validator.InputValidator;
import baseball.validator.RegexValidator;

public record ReplayDto(String replay) {

    public ReplayDto {
        InputValidator.validate(replay);
        RegexValidator.validate(InputPattern.REPLAY, replay);
    }
}
