package baseball.domain.input;

import baseball.domain.input.error.InputError;
import baseball.domain.input.error.InputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class Input {

    public String getExpectationNumber() {
        return Console.readLine();
    }

    public String getRestartOrNot() {
        return Console.readLine();
    }

    public void checkInputNumbers(String numbers) {
        if (!(numbers.length() == 3)) {
            throw new InputException(InputError.NEED_THREE_DIGIT);
        }
        if (!numbers.matches("[1-9]+")) {
            throw new InputException(InputError.MUST_BE_DIGIT);
        }
        if (numbers.length() != Stream.of(numbers.split("")).distinct().count()) {
            throw new InputException(InputError.NEED_NON_DUPLICATE_NUMBERS);
        }
    }
}
