package baseball.domain;

import static baseball.domain.GameConstants.MAX_DIGIT;
import static baseball.domain.GameConstants.MIN_DIGIT;
import static baseball.domain.GameConstants.NUMBER_LENGTH;

import baseball.util.*;
import baseball.validation.IntegerValidator;
import baseball.validation.StringValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class NumberBaseball {

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
        IntegerValidator.validateInteger(stringValue);
        StringValidator.validateShortLength(stringValue, NUMBER_LENGTH);
        StringValidator.validateLongLength(stringValue, NUMBER_LENGTH);
        StringValidator.validateDuplicated(stringValue);
        StringValidator.validateOutOfRange(stringValue, MIN_DIGIT, MAX_DIGIT);
    }

}