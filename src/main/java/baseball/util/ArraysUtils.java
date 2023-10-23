package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysUtils {
    public static List<Integer> stringToList(String str) {
        return Arrays.stream(str.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static boolean isEquals(List<Integer> listA, List<Integer> listB) {
        return Arrays.equals(listA.toArray(), listB.toArray());
    }
}
