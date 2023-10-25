package baseball.util;

import baseball.validation.IntegerValidator;
import java.util.ArrayList;
import java.util.List;

public class IntegerListUtil {

    public static List<Integer> parseIntegerList(String string) {
        List<Integer> integerList = new ArrayList<>();

        for (char character : string.toCharArray()) {
            integerList.add(IntegerUtil.parseInteger(character));
        }

        return integerList;
    }

    public static void addIfNotContained(List<Integer> list, int value) {
        if (!list.contains(value)) {
            list.add(value);
        }
    }

    public static void validateListType(List<?> list) {
        for (Object item : list) {
            IntegerValidator.validateInteger(item);
        }
    }
}
