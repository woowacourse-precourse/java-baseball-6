package baseball.global.utils.validator;

import baseball.global.constant.Common;
import baseball.global.constant.OutputType;

public class RestartInputValidator implements InputValidator {

    @Override
    public void validate(String input) {
        if (!input.equals(Common.RESTART.getContent()) && !input.equals(Common.FINISH.getContent())) {
            throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
        }
    }
}
