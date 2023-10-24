package baseball.io;

import baseball.io.enums.InputMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Input {

    public static final String DEFAULT_SPLIT_REGEX = "";

    public static String consoleLine() {
        return Console.readLine();
    }

    public static Integer consoleNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessage.WRONG_INPUT_VALUE.get(), e);
        }
    }

    public static List<Integer> consoleNumbers() {
        return consoleNumbers(DEFAULT_SPLIT_REGEX);
    }

    public static List<Integer> consoleNumbers(String regex) {
        try {
            return Arrays.stream(Console.readLine().split(regex))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(InputMessage.WRONG_SPLIT_REGEX.get(), e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessage.WRONG_INPUT_VALUE.get());
        }
    }

}
