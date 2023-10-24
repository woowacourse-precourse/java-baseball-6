package baseball;

import java.util.HashSet;

public class ValidateService {
    // 입력값의 길이를 검증하는 로직
    public Boolean validateLength(String inputValue) {
        if (inputValue.length() != 3) return false;
        return true;
    }

    // 입력값의 타입을 검증하는 로직
    public Boolean validateType(String inputValue) {
        for (int i = 0; i < 3; i++) {
            int intValue = inputValue.charAt(i) - 48;
            if (!(1 <= intValue && intValue <= 9)) return false;
        }
        return true;
    }

    // 입력값의 중복을 검증하는 로직
    public Boolean validateDuplicateValue(String inputValue) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if(!set.add(inputValue.charAt(i) - 48)) return false;
        }
        return true;
    }
}
