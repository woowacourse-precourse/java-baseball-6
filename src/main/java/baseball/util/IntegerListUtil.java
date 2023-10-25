package baseball.util;

import static baseball.domain.GameConstants.MAX_DIGIT;
import static baseball.domain.GameConstants.MIN_DIGIT;
import static baseball.domain.GameConstants.NUMBER_LENGTH;

import baseball.validation.IntegerValidator;
import camp.nextstep.edu.missionutils.Randoms;
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

    public static List<Integer> generateRandomList() {
        List<Integer> computerList = new ArrayList<>();
        while (computerList.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
            IntegerListUtil.addIfNotContained(computerList, randomNumber);
        }
        return computerList;
    }

    public static void validateListType(List<?> list) {
        for (Object item : list) {
            IntegerValidator.validateInteger(item);
        }
    }
}
