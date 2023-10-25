package baseball.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.validation.validateGuessNumber.validateGuessNumberLength;
import static baseball.validation.validateGuessNumber.validateGuessNumberNumeric;

public class ConvertToListIntegerUtil {

    public static List<Integer> convertStringToListInteger(String input) {
        validateGuessNumberLength(input);
        validateGuessNumberNumeric(input);
        return Stream.of(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }
}
