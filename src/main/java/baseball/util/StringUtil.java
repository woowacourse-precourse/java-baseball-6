package baseball.util;

import static baseball.domain.GameConstants.NUMBER_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    public static Set toHashSet(String string) {
        Set numSet = new HashSet();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numSet.add(string.charAt(i));
        }
        return numSet;
    }
}
