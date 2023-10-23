package baseball.domain;

import java.util.HashMap;

public class Validation {

    public void runValidation(char[] data, int dataType) {
        validateSize(data, dataType);
        validateNumber(data);
        validateDuplicate(data, dataType);
        validateRestartValue(data, dataType);
    }

    // 올바른 사이즈인지 확인합니다.
    private void validateSize(char[] target, int inputType) {
        if (target.length != inputType) {
            throw new IllegalArgumentException(inputType + "개의 숫자를 입력해야 합니다.");
        }
    }

    // 숫자인지 확인합니다.
    private void validateNumber(char[] target) {
        for (char chr : target) {
            if (chr < 49 || chr > 57) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    // 같은 숫자가 있는지 확인합니다.
    private void validateDuplicate(char[] target, int inputType) {
        if (inputType == 1) {
            return;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char chr : target) {
            hashMap.put(chr, 0);
        }
        if (hashMap.size() != 3) {
            throw new IllegalArgumentException("같은 숫자는 입력할 수 없습니다.");
        }
    }

    // 게임 재시작 값인 '1', '2' 인지 확인합니다.
    private void validateRestartValue(char[] target, int inputType) {
        if (inputType == 3) {
            return;
        }
        if (!(target[0] == ('1')) && !(target[0] == ('2'))) {
            throw new IllegalArgumentException("1, 2 중 하나를 입력해야 합니다.");
        }
    }
}