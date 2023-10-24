package baseball.dto.input;

import baseball.constants.InputPattern;
import baseball.model.Baseball;
import baseball.model.BaseballNumber;
import baseball.validator.InputValidator;
import baseball.validator.RegexValidator;
import java.util.Arrays;
import java.util.List;

public record BaseballDto(String baseball) {

    public BaseballDto {
        InputValidator.validate(baseball);
        RegexValidator.validate(InputPattern.BASEBALL, baseball);
    }

    public Baseball toBaseball() {
        String[] splits = baseball.split("");

        List<BaseballNumber> baseballNumbers = Arrays.stream(splits)
                .map(Integer::parseInt)
                .map(BaseballNumber::new)
                .toList();

        return Baseball.from(baseballNumbers);
    }
}
