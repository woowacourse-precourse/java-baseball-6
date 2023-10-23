package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Input {

    public static String consoleLine() {
        return Console.readLine();
    }

    public static Integer consoleNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다", e);
        }
    }

    public static List<Integer> consoleNumbers() {
        return consoleNumbers("");
    }

    public static List<Integer> consoleNumbers(String regex) {
        try {
            return Arrays.stream(Console.readLine().split(regex))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("적절하지 않은 구분 정규식", e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다");
        }
    }

}
