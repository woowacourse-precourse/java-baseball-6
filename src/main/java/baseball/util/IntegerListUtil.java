package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class IntegerListUtil {

    private static final String INVALID_INTEGER_LIST_ELEMENT_MESSAGE = "List의 요소가 Integer가 아닙니다.";

    public static List<Integer> parseIntegerList(String string){
        List<Integer> integerList = new ArrayList<>();

        for (char character : string.toCharArray()){
            integerList.add(IntegerUtil.parseInteger(character));
        }

        return integerList;
    }

    public static void validateListType(List<?> list) {
        for (Object item : list) {
            if (!(item instanceof Integer)) {
                throw new IllegalArgumentException(INVALID_INTEGER_LIST_ELEMENT_MESSAGE);
            }
        }
    }

}
