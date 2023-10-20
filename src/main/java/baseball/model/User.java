package baseball.model;

import baseball.util.Number;
import java.util.List;

public class User {
    /**
     * 사용자가 입력한 숫자를 정수 리스트로 관리한다.
     */
    List<Integer> numbers;

    /**
     * 입력받은 값이 정수인지 검증하고, List에 저장한다.
     *
     * @param input
     */
    public User(String input) {
        boolean isNumber = Number.validationNumber(input);
        if (!isNumber) {
            throw new IllegalArgumentException();
        }
    }
}

