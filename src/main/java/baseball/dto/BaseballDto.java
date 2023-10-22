package baseball.dto;

import baseball.constants.InputPattern;
import baseball.validator.InputValidator;
import baseball.validator.RegexValidator;

public record BaseballDto(String baseball) {

    public BaseballDto {
        InputValidator.validate(baseball);
        RegexValidator.validate(InputPattern.BASEBALL, baseball);
    }
}
