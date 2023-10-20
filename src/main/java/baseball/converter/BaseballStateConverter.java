package baseball.converter;

import static baseball.constant.BaseballConstants.MAX_MATCH;

import baseball.state.BaseballState;
import baseball.util.StringUtils;
import java.util.List;

public class BaseballStateConverter {

    private static boolean isValidBaseballStateString(String s) {
        if (s.length() != MAX_MATCH || !s.chars().allMatch(Character::isDigit)) {
            return false;
        }

        var setOfChar = StringUtils.stringToSetOfChar(s);
        return setOfChar.size() == MAX_MATCH;
    }

    public static BaseballState stringToBaseballState(String s) throws IllegalArgumentException {
        if (isValidBaseballStateString(s)) {
            List<Integer> state = StringUtils.digitStringToListOfInt(s);
            return new BaseballState(state);
        }
        throw new IllegalArgumentException();
    }
}
