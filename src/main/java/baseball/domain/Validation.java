package baseball.domain;

import java.util.HashMap;

public class Validation {

     public void runValidation(String[] data, int dataType) {
        validateSize(data, dataType);
        validateNumber(data);
        validateDuplicate(data, dataType);
        validateRestartValue(data, dataType);
    }

    // 올바른 사이즈인지 확인합니다.
    private void validateSize(String[] target, int inputType) {
        if (!(target.length == inputType)) throw new IllegalArgumentException();
    }

    // 숫자인지 확인합니다.
    private void validateNumber(String[] target) {
        for (String str : target) {
            char tester = str.charAt(0);
            if(tester < 49 || tester > 57) throw new IllegalArgumentException();
        }
    }

    // 같은 숫자가 있는지 확인합니다.
    private void validateDuplicate(String[] target, int inputType) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (inputType == 1) return;
        for (String str : target) {
            hashMap.put(str, 0);
        }
        if (hashMap.size()!= 3) throw new IllegalArgumentException();
    }

    // 게임 재시작 값인 '1', '2' 인지 확인합니다.
    private void validateRestartValue(String[] target, int inputType) {
        if (inputType == 3) return;
        if (!(target[0].equals("1")) && !(target[0].equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
