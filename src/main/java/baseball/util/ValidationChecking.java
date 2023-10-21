package baseball.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationChecking {
    public static void checkUserInputValidate(List<Integer> userNumber) {

        // 입렧한 수가 3개인지 확인
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException();
        }

        //입력 값이 서로 다른지 확인
        Set<Integer> checkDuplicateData = new HashSet<>(userNumber);
        if (checkDuplicateData.size() != userNumber.size()) {
            throw new IllegalArgumentException();
        }

        //입력 값이 1~9 사이 인지 확인
        //입력 값이 정수인지 확인
        for (Integer number : userNumber) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
