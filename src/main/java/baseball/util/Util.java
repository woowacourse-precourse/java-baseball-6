package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

    //완성시 모든 메서드 테스트


    //try-catch 필요없나 테스트 해보기
    public static void validateStringIsNaturalNumber(String string, String exceptionMessage) {
        int numberByString = Integer.parseInt(string);
        if (numberByString <= 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateStringHasNot(String notContainsString, String string, String exceptionMessage) {
        if (string.contains(notContainsString)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateStringLength(int length, String string, String exceptionMessage) {
        if (string.length() != length) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateStringAllDifferent(String string, String exceptionMessage) {
        for (int i = 0; i < string.length(); i++) {
            String stringByIdx = String.valueOf(string.charAt(i));
            String stringRemoveByIdx = string.substring(0, i) + string.substring(i + 1);
            if (stringRemoveByIdx.contains(stringByIdx)) {
                throw new IllegalArgumentException(exceptionMessage);
            }

        }
    }

    public static String reverseString(String string) {
        StringBuilder stringBuffer = new StringBuilder(string);
        return stringBuffer.reverse().toString();
    }

    //(int)를 써도 괜찮을까 테스트해보기
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

    public static void validateStringIsOneOrTwo(String string) {
        if (!string.equals("1") && !string.equals("2")) {
            throw new IllegalArgumentException("1, 2 중 하나를 입력해주세요");
        }
    }
}
