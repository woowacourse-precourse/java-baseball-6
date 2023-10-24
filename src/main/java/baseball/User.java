package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> input;

    public User(String input, Integer length) {
        this.input = convert(input, length);
    }

    public List<Integer> getInput() {
        return input;
    }

    private List<Integer> convert(String string, Integer length) {
        if (string.length() != length || string.indexOf("0") > -1) {
            // 길이가 다르거나 0을 포함하면 throw
            throw new IllegalArgumentException();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '1' && string.charAt(i) <= '9'
                    && result.indexOf(string.charAt(i) - '0') < 0) {
                result.add(string.charAt(i) - '0');
            } else {
                // 숫자가 아니거나 중복된 값이 있으면 throw
                throw new IllegalArgumentException();
            }
        }

        return result;
    }
}
