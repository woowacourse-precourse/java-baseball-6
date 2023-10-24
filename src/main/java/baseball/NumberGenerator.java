package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberGenerator { // Updated class name
    private static final int DIGITS = 3;

    public List<Integer> generateRandomNumbers() { // Updated method name
        Set<Integer> numberSet = new HashSet<>(); // Updated variable name
        while (numberSet.size() < DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numberSet.add(randomNumber);
        }
        return new ArrayList<>(numberSet);
    }

    public List<Integer> getInputNumber() { // Updated method name
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!isValidInputString(input)) { // Updated method name
            throw new IllegalArgumentException();
        }
        return stringToList(input); // Updated method call
    }

    private List<Integer> stringToList(String str) { // Updated method name
        return str.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    private boolean isValidInputString(String input) { // Updated method name
        if (!isNotDuplicate(input) || !isNumeric(input) || !isThreeDigits(input)) {
            return false;
        }
        return true;
    }

    private boolean isThreeDigits(String input) { // Updated method name
        return input.length() == DIGITS;
    }

    private boolean isNumeric(String str) { // Updated method name
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }

    private boolean isNotDuplicate(String str) { // Updated method name
        Set<Character> set = new HashSet<>();
        for (char num : str.toCharArray()) {
            set.add(num);
        }
        return set.size() == str.length();
    }
}
