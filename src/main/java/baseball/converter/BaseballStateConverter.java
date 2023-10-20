package baseball.converter;

import baseball.state.BaseballState;
import baseball.util.StringUtils;
import java.util.List;

public class BaseballStateConverter {
    public static BaseballState stringToBaseballState(String s) throws IllegalArgumentException {
        if (s.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (!s.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        var setOfChar = StringUtils.stringToSetOfChar(s);
        if (setOfChar.size() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> state = StringUtils.digitStringToListOfInt(s);

        return new BaseballState(state);
    }
}
