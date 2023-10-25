package baseball;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Input {

    public List<Integer> stringToList(String str) {
        return Arrays.stream(str.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public boolean isValidInput(String input) {
        return isNotDuplicate(input) && isNumber(input) && isThreeDigits(input);
    }

    public List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = ConsoleUtils.readLine();
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }
        return stringToList(input);
    }

    private boolean isThreeDigits(String input) {
        return input.length() == 3;
    }

    private boolean isNumber(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }

    private boolean isNotDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for (char num : str.toCharArray()) {
            set.add(num);
        }
        return set.size() == str.length();
    }
}
