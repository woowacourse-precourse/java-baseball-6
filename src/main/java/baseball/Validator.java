package baseball;


import java.util.List;
import java.util.Set;

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

    // 사용자가 입력한 숫자가 3자리 숫자인지 확인해주는 메서드
    public static Boolean validNum(String invalidNums) {
        if (checkLength(invalidNums) && checkZeroNum(invalidNums) && checkDuplicationNum(invalidNums)) {
            return TRUE;
        }
        return FALSE;
    }

    private static Boolean checkLength(String invalidNums) {
        if (invalidNums.length() != BASEBALL_NUM_LIMIT_LENGTH) {
            return FALSE;
        }
        return TRUE;
    }

    private static Boolean checkZeroNum(String invalidNums) {
        if (invalidNums.contains(NOT_ALLOW_BASEBALL_NUMBER)) {
            return FALSE;
        }
        return TRUE;
    }

    private static Boolean checkDuplicationNum(String invalidNums) {
        Set<String> invalidNums1 = Set.of(invalidNums);
        if (invalidNums1.size() != BASEBALL_NUM_LIMIT_LENGTH) {
            return FALSE;
        }
        return TRUE;
    }
}