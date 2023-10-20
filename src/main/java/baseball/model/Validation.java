package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private static final String SAME_NUMBER_EXCEPTION_MESSAGE = "같은 숫자를 입력할 수 없습니다.";

    public static void validateSameNumber(String numbers) {
        List<Character> checkList = new ArrayList<>();

        for (char singleNumber : numbers.toCharArray()) {
            if (checkList.contains(singleNumber)) {
                throw new IllegalArgumentException(SAME_NUMBER_EXCEPTION_MESSAGE);
            }
            checkList.add(singleNumber);
        }
    }
}
