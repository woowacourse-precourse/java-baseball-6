package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

    private InputUtil() {}
    public static List<String> stringInputToArr() {
        return Arrays.stream(Console.readLine().split("")).collect(Collectors.toList());
    }

    public static String stringInput() {
        return Console.readLine();
    }
}
