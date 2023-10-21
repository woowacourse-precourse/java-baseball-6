package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";

    //완성시 모든 메서드 테스트
    public static List<Integer> stringToIntegerList(String string) {
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

    public static int countSameValueDifferentIdxByList(List<Integer> integerList1, List<Integer> integerList2) {
        int count = 0;
        for (int i = 0; i < integerList1.size(); i++) {
            count += countSameValueDifferentIdxBetweenListAndValue(integerList1.get(i), i, integerList2);
        }
        return count;
    }

    public static int countSameValueDifferentIdxBetweenListAndValue(int value, int idx, List<Integer> integerList) {
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
