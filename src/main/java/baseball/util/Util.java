package baseball.util;

import baseball.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";

    //완성시 모든 메서드 테스트
    public static List<Integer> naturalNumberstringToIntegerList(String string) {
        Validator.validateStringIsNaturalNumber(string, "문자열이 자연수로 이루어있지않습니다.");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            integerList.add(string.charAt(i) - '0');
        }
        return integerList;
    }

    public static int countSameValueSameIdxByIntegerList(List<Integer> integerList1, List<Integer> integerList2) {
        int count = 0;
        for (int i = 0; i < integerList1.size(); i++) {
            count += countSameValueSameIdxBetweenIntegerListAndValue(integerList1.get(i), i, integerList2);
        }
        return count;
    }

    public static int countSameValueSameIdxBetweenIntegerListAndValue(int value, int idx, List<Integer> integerList) {
        int count = 0;
        for (int i = 0; i < integerList.size(); i++) {
            Integer integer = integerList.get(i);
            if (integer == value && idx == i) {
                count++;
            }
        }
        return count;
    }

    public static int countSameValueDifferentIdxByIntegerList(List<Integer> integerList1, List<Integer> integerList2) {
        int count = 0;
        for (int i = 0; i < integerList1.size(); i++) {
            count += countSameValueDifferentIdxBetweenIntegerListAndValue(integerList1.get(i), i, integerList2);
        }
        return count;
    }

    public static int countSameValueDifferentIdxBetweenIntegerListAndValue(int value, int idx, List<Integer> integerList) {
        int count = 0;
        for (int i = 0; i < integerList.size(); i++) {
            Integer integer = integerList.get(i);
            if (integer.equals(value) && idx != i) {
                count++;
            }
        }
        return count;
    }
}
