package baseball.converter;

import static java.util.stream.Collectors.*;

import baseball.state.BaseballState;
import baseball.utils.IoHelper;
import baseball.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballStateConverter {
    public static BaseballState stringToBaseballState(String s) throws IllegalArgumentException{
        IoHelper.println("this is s => " + s);
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
        List<Integer> state = s.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
        return new BaseballState(state);
    }
}
