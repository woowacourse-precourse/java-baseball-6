package baseball.domain;

import static baseball.domain.GameConstants.NUMBER_LENGTH;

import baseball.util.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class NumberBaseball {

    private static final String TOO_SHORT_LENGTH_MESSAGE = String.format(
            "자리수가 %d보다 작습니다.",
            NUMBER_LENGTH);
    private static final String TOO_LONG_LENGTH_MESSAGE = String.format(
            "자리수가 %d보다 큽니다.",
            NUMBER_LENGTH);
    private static final String DUPLICATE_DIGITS_MESSAGE = "같은 숫자가 2개 이상 있습니다.";
    private static final String OUT_OF_RANGE_DIGITS_MESSAGE = String.format(
            "각 자리 숫자가 %d에서 %d 사이가 아닙니다.",
            GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);

    private final List values;

    private NumberBaseball(List values) {
        this.values = values;
    }

    public static NumberBaseball createBaseball(String stringValue) {
        validateStringValue(stringValue);
        List values = IntegerListUtil.parseIntegerList(stringValue);

        return new NumberBaseball(values);
    }

    public static NumberBaseball createBaseball(List values) {
        IntegerListUtil.validateListType(values);

        return new NumberBaseball(values);
    }

    public static NumberBaseball createRandomBaseball() { //정적 팩터리 메서드
        List<Integer> computerList = new ArrayList<>();

        while (computerList.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);
            IntegerListUtil.addIfNotContained(computerList, randomNumber);
        }
        return createBaseball(computerList);
    }

    public List getValues() {
        return values;
    }

    public int getValueSize() {
        return values.size();
    }

    private static void validateStringValue(String stringValue) {
        int stringLen = stringValue.length();

        IntegerUtil.validateInteger(stringValue);
        validateShortLength(stringLen);
        validateLongLength(stringLen);
        validateDuplicated(stringValue);
        validateOutOfRange(stringValue);
    }

    private static void validateShortLength(int stringLen) {
        if (stringLen < NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException(TOO_SHORT_LENGTH_MESSAGE);
        }
    }

    private static void validateLongLength(int stringLen) {
        if (stringLen > NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException(TOO_LONG_LENGTH_MESSAGE);
        }
    }

    private static void validateDuplicated(String stringValue) {
        Set valueSet = StringUtil.toHashSet(stringValue);

        if (valueSet.size() < NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_DIGITS_MESSAGE);
        }
    }

    private static void validateOutOfRange(String stringValue) {
        if (!stringValue.matches("^[1-9]+$")) {
            ExceptionUtil.throwInvalidValueException(OUT_OF_RANGE_DIGITS_MESSAGE);
        }
    }
}