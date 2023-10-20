package baseball.converter;

import static baseball.constant.BaseballConstants.MAX_MATCH;

import baseball.state.BaseballState;
import baseball.util.StringUtil;

public class BaseballStateConverter {

    private static boolean isValidBaseballStateString(String s) {
        if (s.length() != MAX_MATCH || !StringUtil.isDigitString(s)) {
            return false;
        }

        var setOfChar = StringUtil.stringToSetOfChar(s);
        return setOfChar.size() == MAX_MATCH;
    }

    public static BaseballState stringToBaseballState(String s) throws IllegalArgumentException {
        if (isValidBaseballStateString(s)) {
            var state = StringUtil.digitStringToListOfInt(s);
            return new BaseballState(state);
        }
        throw new IllegalArgumentException();
    }
}
