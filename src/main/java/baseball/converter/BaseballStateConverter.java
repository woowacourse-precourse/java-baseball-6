package baseball.converter;

import static baseball.constant.BaseballConstants.MAX_MATCH;

import baseball.state.BaseballState;
import baseball.util.StringUtil;

public class BaseballStateConverter {

    private static boolean isValidBaseballStateString(String s) {
        if (s.length() != MAX_MATCH) {
            return false;
        }
        if (!StringUtil.isDigitString(s)) {
            return false;
        }

        var setOfChar = StringUtil.stringToSetOfChar(s);
        return setOfChar.size() == MAX_MATCH;
    }

    public static BaseballState stringToBaseballState(String s) throws IllegalArgumentException {
        if (isValidBaseballStateString(s)) {
            var rawStateList = StringUtil.digitStringToListOfInt(s);
            return new BaseballState(rawStateList);
        }
        throw new IllegalArgumentException();
    }
}
