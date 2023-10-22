package baseball;

import static baseball.Constant.MAX_DIGIT;
import static baseball.Constant.MAX_NUM;
import static baseball.Constant.ONE_DIGIT;
import static baseball.Utils.stringToInt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    static void gameInputValidator(String string) throws IllegalArgumentException {
        List<Integer> integerList = new ArrayList<>(stringToInt(string));
        isEmpty(integerList);
        isThreeDigit(integerList);
        isPositive(integerList);
        isUnderTen(integerList);
        hasDuplicate(integerList);
    }

    static void restartInputValidator(String string) throws IllegalArgumentException {
        List<Integer> integerList = new ArrayList<>(stringToInt(string));
        isEmpty(integerList);
        isOneDigit(integerList);
    }

    static void isEmpty(List<Integer> integerList) {
        if (integerList.isEmpty()) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    static void isThreeDigit(List<Integer> integerList) {
        if (integerList.size() != MAX_DIGIT) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요");
        }
    }

    static void isOneDigit(List<Integer> integerList) {
        if (integerList.size() != ONE_DIGIT) {
            throw new IllegalArgumentException("1자리의 숫자를 입력해주세요");
        }
    }

    static void isPositive(List<Integer> integerList) {
        for (int i : integerList) {
            if (i <= 0) {
                throw new IllegalArgumentException("0이상의 숫자만 가능합니다");
            }
        }
    }

    static void isUnderTen(List<Integer> integerList) {
        for (int i : integerList) {
            if (i > MAX_NUM) {
                throw new IllegalArgumentException("9이하의 숫자만 가능합니다");
            }
        }
    }

    static void hasDuplicate(List<Integer> integerList) {
        Set<Integer> set = new HashSet<>(integerList);
        if (set.size() != integerList.size()) {
            throw new IllegalArgumentException("중복 없는 3자리수를 입력해주세요");
        }
    }

}
