package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    private final char restart = '1';
    private final char end = '2';

    //뭔가... validation.........별론디.....
    //여기저기 흩어진 상수들도 별로다 뭔가...
    public void validateThreeNumbers(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("숫자만 입력해 주세요");
            }
            if (num == '0') {
                throw new IllegalArgumentException("1 ~ 9 숫자만 넣어주세요. 0은 입력할 수 없습니다.");
            }
            charSet.add(num);
        }
        if (charSet.size() != 3) {
            throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다");
        }
    }
    public void validateSign(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("1 혹은 2만 입력해 주세요.");
        }
        if (input.charAt(0) != restart && input.charAt(0) != end) {
            throw new IllegalArgumentException("재시작은 1, 종료는 2 입니다.");
        }
    }
}
