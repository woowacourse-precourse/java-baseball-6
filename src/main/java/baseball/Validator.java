package baseball;


import java.util.HashSet;
import java.util.List;

import static baseball.Constant.BASEBALL_NUM_LIMIT_LENGTH;
import static baseball.Constant.NOT_ALLOW_BASEBALL_NUMBER;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Validator {
    public Validator() {
    }

    // 컴퓨터를 통한 랜덤 야구번호를 검증해주는 메서드
    public static Boolean validNumNotInList(String invalidNum, List<String> validNumList) {
        return validNumList.contains(invalidNum);
    }

    public static Boolean checkLength(String invalidNums) {
        if (invalidNums.length() != BASEBALL_NUM_LIMIT_LENGTH) {
            return FALSE;
        }
        return TRUE;
    }

    public static Boolean checkZeroNum(String invalidNums) {
        if (invalidNums.contains(NOT_ALLOW_BASEBALL_NUMBER)) {
            return FALSE;
        }
        return TRUE;
    }

    public static Boolean checkDuplicationNum(String invalidNums) {
        char[] invalidNumList = invalidNums.toCharArray();
        HashSet<Character> invalidNumSet = new HashSet<>();
        for (char num : invalidNumList) {
            invalidNumSet.add(num);
        }
        if (invalidNumSet.size() != BASEBALL_NUM_LIMIT_LENGTH) {
            return FALSE;
        }
        return TRUE;
    }
}