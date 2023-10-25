package baseball;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String userNum;

    public void updateUserNum(String userNum) {
        validateInput(userNum);
        this.userNum = userNum;
    }

    private void validateInput(String value) {
        if (!(isValidatedInputSize(value)
                && isValidatedInputEachNum(value)
                && isValidatedInputDuplicate(value))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidatedInputSize(String value) {
        if (value.length() == 3) {
            return true;
        }
        return false;
    }

    private boolean isValidatedInputEachNum(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!('1' <= value.charAt(i) && value.charAt(i) <= '9')) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidatedInputDuplicate(String value) {
        Set<Character> set = new HashSet<>();
        int originSize = value.length();

        for (int i = 0; i < value.length(); i++) {
            set.add(value.charAt(i));
        }

        if (set.size() == originSize) {
            return true;
        }

        return false;
    }
}
