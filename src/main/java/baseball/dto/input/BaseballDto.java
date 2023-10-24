package baseball.dto.input;

import baseball.constants.InputPattern;
import baseball.model.Baseball;
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

        List<Integer> baseballNumbers = Arrays.stream(splits)
                .map(Integer::parseInt)
                .toList();

        return Baseball.from(baseballNumbers);
    }
}
