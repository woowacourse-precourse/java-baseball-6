package baseball;

import java.util.HashMap;
import java.util.Map;

public class PlayerNumberValidator {
    private Map<String, Integer> map;

    public PlayerNumberValidator() {
        map = new HashMap<>();
    }

    public boolean isValidNumber(String number, int length) {
        if (number == null || number.length() != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char cur = number.charAt(i);
            if (cur < '1' || cur > '9' || map.containsKey(String.valueOf(cur))) {
                return false;
            } else {
                map.put(String.valueOf(cur), 1);
                return true;
            }
        }
        return true;
    }
}
