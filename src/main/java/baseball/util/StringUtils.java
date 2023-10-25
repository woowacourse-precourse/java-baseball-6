package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private static final String NUMERIC_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private StringUtils() {}

    public static List<Integer> stringToIntegerList(String target) {
        String[] sliceTarget = target.split("");

        List<Integer> resultList = new ArrayList<>();
        for (String ball:sliceTarget) {
            if (!isNumeric(ball)) {
                throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
            }
            resultList.add(Integer.valueOf(ball));
        }

        return resultList;
    }

    public static int stringToNumber(String target) {
        if (isNumeric(target)) {
            return Integer.parseInt(target);
        }

        throw new IllegalArgumentException();
    }

    public static boolean isNumeric(String target) {
        return target.matches("[1-9]+");
    }
}
