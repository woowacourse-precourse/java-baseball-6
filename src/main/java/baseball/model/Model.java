package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public static String inputThreeNumber() {
        return Console.readLine();
    }

    public static void isInputThreeNumber(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
        }
        for (int i = 0; i < 3; i++) {
            boolean isNum = Character.isDigit(str.charAt(i));
            if (!isNum) {
                throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요");
            }
        }
    }

    public static List<Integer> stringToIntegerList(String stringNumber) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < stringNumber.length(); i++) {
            char c = stringNumber.charAt(i);
            int digit = Character.getNumericValue(c);
            list.add(digit);
        }
        if (list.get(0) == list.get(1) || list.get(1) == list.get(2) || list.get(2) == list.get(0)) {
            throw new IllegalArgumentException("3개의 숫자는 달라야 합니다");
        }
        return list;
    }
}
