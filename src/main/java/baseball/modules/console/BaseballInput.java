package baseball.modules.console;

import static baseball.utils.BaseballNumberConstants.*;
import static baseball.utils.BaseballNumberConstants.END_RANGE;
import static baseball.utils.BaseballNumberConstants.START_RANGE;
import static java.util.Arrays.stream;

import baseball.utils.NumberUtils;
import baseball.utils.StringUtils;

public class BaseballInput extends UserInput{


    public BaseballInput(final String input) {
        super(input);
    }

    void validate(final String input) {
        if (!StringUtils.isLengthEqual(input, MAX_BASEBALL_NUMBER_SIZE.getConstant())) {
            throw new IllegalArgumentException();
        }

        if (StringUtils.hasDuplicate(input)) {
            throw new IllegalArgumentException();
        }

        if (!StringUtils.isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        if (stream(input.split(""))
                .map(Integer::parseInt)
                .anyMatch(value -> !NumberUtils.isWithInRange(
                        value,
                        START_RANGE.getConstant(),
                        END_RANGE.getConstant()))
        ) {
            throw new IllegalArgumentException();
        }
    }
}
