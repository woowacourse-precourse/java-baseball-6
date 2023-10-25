package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 민경수
 * @description array converter util
 * @since 2023.10.25
 **********************************************************************************************************************/
public class ArrayConverterUtil {

    public static List<Integer> converIntArrayToList(int[] numbers) {
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}