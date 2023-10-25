package baseball.dto.request;

import baseball.common.exception.input.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.common.config.GameConfig.SPLIT_REGEXP;
import static baseball.common.exception.input.InputErrorCode.NON_NUMERIC;

public class UserNumberRequest {
    private final List<Integer> numberList;

    public UserNumberRequest(final String arg) {
        checkNumeric(arg);
        this.numberList = parseStringToIntegerList(arg);
    }

    private void checkNumeric(String arg) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new InputException(NON_NUMERIC);
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    private static List<Integer> parseStringToIntegerList(final String arg) {
        return Arrays.stream(arg.split(SPLIT_REGEXP)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
