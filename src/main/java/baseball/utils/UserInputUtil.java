package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserInputUtil {

    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> integerList = new ArrayList<>();
        for(String s : input.split("")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    public static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 애플리케이션을 종료합니다.");
        }
    }

    public static void validateNaturalNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다. 애플리케이션을 종료합니다.");
            }
        }
    }
}
