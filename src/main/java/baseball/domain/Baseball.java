package baseball.domain;

import baseball.util.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Baseball {

    private static final String TOO_SHORT_LENGTH_MESSAGE = "자리수가 3보다 작습니다.";
    private static final String TOO_LONG_LENGTH_MESSAGE = "자리수가 3보다 큽니다.";
    private static final String DUPLICATE_DIGITS_MESSAGE = "같은 숫자가 2개 이상 있습니다.";
    private static final String OUT_OF_RANGE_DIGITS_MESSAGE = "각 자리 숫자가 1에서 9사이가 아닙니다.";

    private final List values;

    //생성자 대신 정적 팩터리 메서드 사용
    private Baseball(List values) {
        this.values = values;
        IntegerListUtil.validateListType(values);
    }

    public static Baseball createBaseball(String stringValue) {
        IntegerUtil.validateInteger(stringValue);

        int stringLen = stringValue.length();
        validateShortLength(stringLen);
        validateLongLength(stringLen);
        validateDuplicated(stringValue);
        validateOutOfRange(stringValue);

        List values = IntegerListUtil.parseIntegerList(stringValue);

        return new Baseball(values);
    }

    public static Baseball createBaseball(List values) {
        return new Baseball(values);
    }

    public static Baseball createRandomBaseball() { //정적 팩터리 메서드
        List<Integer> computerList = new ArrayList<>();

        while (computerList.size() < GameConstants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber);
            }
        }

        return createBaseball(computerList);
    }

    public List getValues() {
        return values;
    }

    private static void validateShortLength(int stringLen) {
        if (stringLen < GameConstants.NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException(TOO_SHORT_LENGTH_MESSAGE);
        }
    }

    private static void validateLongLength(int stringLen) {
        if (stringLen > GameConstants.NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException(TOO_LONG_LENGTH_MESSAGE);
        }
    }

    private static void validateDuplicated(String stringValue) {
        Set numSet = new HashSet();

        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            numSet.add(stringValue.charAt(i));
        }

        if (numSet.size() < GameConstants.NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_DIGITS_MESSAGE);
        }
    }

    private static void validateOutOfRange(String stringValue) {
        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            if (!stringValue.matches("^[1-9]+$")) {
                ExceptionUtil.throwInvalidValueException(OUT_OF_RANGE_DIGITS_MESSAGE);
            }
        }
    }

}
