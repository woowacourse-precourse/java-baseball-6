package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateInput {
    static void validateInput(String test) {
        if (test.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
        try {
            Integer.parseInt(test);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
        if (test.contains("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다");
        }
        if (test.contains(" ")) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다");
        }
        Set<String> set = new HashSet<String>(Arrays.asList(test.split("")));
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다");
        }

    }
}