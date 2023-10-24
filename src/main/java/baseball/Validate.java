package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validate {
    private static void validateNumber(String number) {
        String regex = "[1-9]{1,3}";
        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException();
        }
    }

    private static void duplicateNumber(String number) {
        List<String> splitNumberContainer = List.of(number.split(""));
        Set<String> numberContainer = new HashSet<>(splitNumberContainer);
        if (number.length() != numberContainer.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputValue(String number) {
        validateNumber(number);
        duplicateNumber(number);
    }
}