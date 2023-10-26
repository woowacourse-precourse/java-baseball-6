package baseball.util;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/*
 *   기능을 작은 단위로 나눴을때에 일반화될 가능성이 있는 메서드를 모은 클래스
 * */

public class Util {
    public static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";
    private static final int COUNT_ZERO = 0;
    private static final char CHAR_ZERO = '0';

    public static List<Integer> createRandomNumberList(int size, int numberBegin, int numberEnd) {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(numberBegin, numberEnd);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public static List<Integer> naturalNumberstringToIntegerList(String string) {
        Validator.validateStringIsNaturalNumber(string, "문자열이 자연수로 이루어있지않습니다.");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            integerList.add(string.charAt(i) - CHAR_ZERO);
        }
        return integerList;
    }

    public static int countSameValueSameIdxByIntegerLists(List<Integer> integerList1, List<Integer> integerList2) {
        int count = COUNT_ZERO;
        for (int i = 0; i < integerList1.size(); i++) {
            count += countSameValueSameIdxBetweenIntegerListAndValue(integerList1.get(i), i, integerList2);
        }
        return count;
    }

    public static int countSameValueSameIdxBetweenIntegerListAndValue(int value, int idx, List<Integer> integerList) {
        int count = COUNT_ZERO;
        for (int i = 0; i < integerList.size(); i++) {
            Integer integer = integerList.get(i);
            if (integer == value && idx == i) {
                count++;
            }
        }
        return count;
    }

    public static int countSameValueDifferentIdxByIntegerLists(List<Integer> integerList1, List<Integer> integerList2) {
        int count = COUNT_ZERO;
        for (int i = 0; i < integerList1.size(); i++) {
            count += countSameValueDifferentIdxBetweenIntegerListAndValue(integerList1.get(i), i, integerList2);
        }
        return count;
    }

    public static int countSameValueDifferentIdxBetweenIntegerListAndValue(int value, int idx,
                                                                           List<Integer> integerList) {
        int count = COUNT_ZERO;
        for (int i = 0; i < integerList.size(); i++) {
            Integer integer = integerList.get(i);
            if (integer.equals(value) && idx != i) {
                count++;
            }
        }
        return count;
    }
}
