package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    public static void isValidInput(String input, int size) {
        if (!isNaturalNumbers(input)) {
            throw new IllegalArgumentException("자연수만 입력해야합니다.");
        } else if (!isValidSize(input, size)) {
            throw new IllegalArgumentException("세 개의 수를 입력해야합니다.");
        } else if (!isNotDuplication(input)) {
            throw new IllegalArgumentException("중복된 수를 입력했습니다.");
        }
    }

    public static boolean isValidSize(String input, int size) {
        return input.length() == size;
    }

    public static boolean isNaturalNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') return false;
        }
        return true;
    }

    public static boolean isNotDuplication(String input) {
        List<Character> list = new ArrayList<Character>();

        for (char c : input.toCharArray()) {
            list.add(c);
        }

        Set<Character> set = new HashSet<>(list);

        return list.size() == set.size();
    }


}
