package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserNumber {
    private Map<Integer, Integer> value;

    public UserNumber() {
        this.value = new HashMap<>();
    }

    /**
     * 사용자가 숫자를 입력하고 Map 으로 변환, 예외 처리
     *
     * @param inputNumber(타입 : String) : 사용자 입력값
     */
    public void inputUserNumber(String inputNumber) {
        this.value = IntStream.rangeClosed(1, 3)
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        i -> {
                            char digit = inputNumber.charAt(i - 1); // 9
                            numberValidate(digit);
                            return Character.getNumericValue(digit);
                        }
                ));
    }

    private void numberValidate(char digit) {
        if (digit <= 48 || digit >= 58) {
            throw new IllegalArgumentException("0 또는 숫자가 아닌 값이 포함되었습니다.");
        }
    }

    public Map<Integer, Integer> getValue() {
        return value;
    }
}
