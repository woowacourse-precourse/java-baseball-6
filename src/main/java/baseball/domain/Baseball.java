package baseball.domain;

import baseball.util.ExceptionUtil;
import baseball.util.IntegerListUtil;
import baseball.util.IntegerUtil;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseball { //TODO: NumberBaseball로 이름 바꾸기

    private static final String TOO_SHORT_INPUT = "자리수가 3보다 작습니다.";
    private static final String TOO_LONG_INPUT = "자리수가 3보다 큽니다.";
    private static final String DUPLICATE_DIGITS = "같은 숫자가 2개 이상 있습니다.";
    private static final String OUT_OF_RANGE_DIGITS = "각 자리 숫자가 1에서 9 사이가 아닙니다.";

    private final List values;

    //생성자 대신 정적 팩터리 메서드 사용
    private Baseball(List values) {
        this.values = values;
        IntegerListUtil.validateListType(values);
    }

    public static Baseball createBaseball(String stringValue) {
        IntegerUtil.validateInteger(stringValue);
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


    private void validate(String stringValue) {

        int inputNumLen = stringValue.length();
        if (inputNumLen < GameConstants.NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException();
        }

        if (inputNumLen > GameConstants.NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException();
        }

        Set numSet = new HashSet();
        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            numSet.add(stringValue.charAt(i));
        }
        if (numSet.size() < GameConstants.NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException();
        }

        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            if (!stringValue.matches("^[1-9]+$")) {
                ExceptionUtil.throwInvalidValueException();
            }
        }
    }


}
