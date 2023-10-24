package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private static final String INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final int SIZE = 3;

    public List<Integer> getNumber() {
        System.out.print(INPUT_STRING);
        String input = Console.readLine();

        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }
        return stringToList(input);
    }

    private List<Integer> stringToList(String input) {
        List<Integer> result = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            result.add(Character.getNumericValue(ch));
        }
        return result;
    }

    private boolean isValidInput(String input) {
        if (input == null || input.length() != SIZE) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || ch == '0') {
                return false;
            }
        }

        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : input.toCharArray()) {
            uniqueChars.add(ch);
        }

        if (uniqueChars.size() != input.length()) {
            return false;
        }
        return true;
    }
}
