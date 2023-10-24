package baseball;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumberValidator {
    private Set<String> set;

    public PlayerNumberValidator() {
        set = new HashSet<>();
    }

    public boolean isValidNumber(String number) {
        if (number == null || number.length() != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            char cur = number.charAt(i);
            if (cur < '1' || cur > '9' || set.contains(cur)) {
                return false;
            } else {
                set.add(String.valueOf(cur));
                return true;
            }
        }
        return true;
    }
}
