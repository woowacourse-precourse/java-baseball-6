package baseball.util;

import baseball.domain.RetryCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.util.ErrorMessage.NUMERIC_ERROR;
import static baseball.util.ErrorMessage.RETRY_COMMAND_ERROR;

public class TypeConvertor {

    private static final String SPLIT_UNIT = "";

    public List<Integer> convertStringToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] split = input.split(SPLIT_UNIT);
        for (String s : split) {
            int digit = toInt(s);
            list.add(digit);
        }
        return list;
    }

    private int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    public RetryCommand findByInput(String input) {
        return Arrays.stream(RetryCommand.values())
                .filter(command -> command.getNumber().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(RETRY_COMMAND_ERROR));
    }
}
