package baseball;


import java.util.List;

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
    public static Boolean validNum(String invalidNums){
        if (validLength(invalidNums) && validNonZero(invalidNums)) {
            return TRUE;
        }
        return FALSE;
    }

    private static Boolean validLength(String invalidNums) {
        if (invalidNums.length() != 3) {
            return FALSE;
        }
        return TRUE;
    }

    private static Boolean validNonZero(String invalidNums) {
        if (invalidNums.contains("0")) {
            return FALSE;
        }
        return TRUE;
    }
}