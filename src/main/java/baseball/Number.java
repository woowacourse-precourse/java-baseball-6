package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Number {
    public List<Integer> setRandomNumbers() {
        Set<Integer> NumberSet = new HashSet<>();
        while (NumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            NumberSet.add(randomNumber);
        }
        return new ArrayList<>(NumberSet);
    }

    public List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if(!isValidString(input)) {
            throw new IllegalArgumentException();
        }
        return stringToList(input);
    }

    private List<Integer> stringToList(String str) {
        return Arrays.stream(str.split("")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isValidString(String input) {
        if(!isNotDuplicate(input) || !isNumber(input) || !isThreeDigits(input)) {
            return false;
        }
        return true;
    }

    private boolean isThreeDigits(String input) {
        if(input.length() != 3) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }

    private boolean isNotDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for(char num : str.toCharArray()) {
            set.add(num);
        }
        return set.size() == str.length();
    }
}
