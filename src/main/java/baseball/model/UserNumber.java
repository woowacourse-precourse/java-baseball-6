package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {
    private final List<Integer> userNumber;

    public UserNumber(String inputNumber) {
        this.userNumber = getIntegers(inputNumber);
        checkUserInputValidate(this.userNumber);
    }

    public List<Integer> getInputNumber() {
        return Collections.unmodifiableList(this.userNumber);
    }

    private static List<Integer> getIntegers(String string) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            int currentInteger = (int) (string.charAt(i)) - '0';
            list.add(currentInteger);
        }

        return list;
    }

    private static void checkUserInputValidate(List<Integer> userNumber) {
        Set<Integer> checkDuplicateData = new HashSet<>(userNumber);

        // 입렧한 수가 3개인지 확인
        // 입력 값이 서로 다른지 확인
        // 입력 값이 1~9 사이 인지 확인
        for (Integer number : userNumber) {
            if (checkDuplicateData.size() != userNumber.size()
                    || userNumber.size() != 3
                    || number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
