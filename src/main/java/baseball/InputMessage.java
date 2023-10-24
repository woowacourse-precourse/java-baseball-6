package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputMessage {

    private static final String threeNumbersFromOneToNineRegex = "[1-9]{3}";
    private static final String numberOne = "1", numberTwo = "2";


    public static List<Integer> predictionInput() {
        return convertThreeNumericStringToIntegerList(readLine());
    }

    public static List<Integer> convertThreeNumericStringToIntegerList(String str) {
        validateThreeNumericString(str);
        return IntStream.range(0, str.length())
                .map(i -> Integer.parseInt(str.substring(i, i + 1)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validateThreeNumericString(String str) {
        if (!str.matches(threeNumbersFromOneToNineRegex)) {
            throw new IllegalArgumentException();
        }
        if (str.chars().distinct().count() != str.length()) {
            throw new IllegalArgumentException();
        }
    }

    public static String restartInput() {
        String input = readLine();
        validateRestartNumericString(input);
        return input;
    }

    private static void validateRestartNumericString(String str) {
        if (!str.equals(numberOne) && !str.equals(numberTwo)) {
            throw new IllegalArgumentException();
        }
    }
}
