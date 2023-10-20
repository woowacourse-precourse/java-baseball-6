package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * For validating the user input.
 * Validation rule:
 *     1. The input should 3 integers, each of which ranges from 1 to 9.
 *     2. Length of input should be 3. Not longer and not shorter.
 *     3. The input is a string, which isn't yet parsed into an integer.
 *     4. No duplicate is allowed.
 */
public class Validator {

    /**
     * Validate input whether it follows the rule specified above.
     * If input isn't valid, throws an exception.
     * If the input doesn't follow the rule, IllegalArgumentException is thrown.
     * @param input of the user to validate.
     */
    public void validate(String input) {
        Pattern pattern = Pattern.compile("[1-9][1-9][1-9]");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력이 잘못됐습니다.");
        }
        String[] split = input.split("");
        if (hasDuplicate(split)) {
            throw new IllegalArgumentException("입력이 잘못됐습니다.");
        }
    }

    private boolean hasDuplicate(String[] chars) {
        return chars[0].equals(chars[1])
                || chars[0].equals(chars[2])
                || chars[1].equals(chars[2]);
    }
}
