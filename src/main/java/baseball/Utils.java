package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Utils {
    public static List<String> divideByOneLatter(String string) {
        return IntStream.range(0, string.length())
                .mapToObj(i -> string.substring(i, i + 1))
                .toList();
    }

    public static boolean isInRange(int number, int start, int end) {
        return number >= start && number <= end;
    }

    public static List<Integer> stringListToIntList(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
