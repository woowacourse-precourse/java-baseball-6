package baseball.model;

import baseball.util.Number;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    /**
     * 사용자가 입력한 숫자를 정수 리스트로 관리한다.
     */
    public List<Integer> numbers = new ArrayList<>();

    /**
     * 입력받은 값이 정수인지 검증하고, List에 저장한다.
     *
     * @param input
     */
    public User(String input) {
        boolean isNumber = Number.validationNumber(input); // 입력값 숫자 여부 확인
        if (!isNumber) { // 숫자가 아닐 경우 예외 발생
            throw new IllegalArgumentException();
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        int number = Integer.parseInt(input); // 입력받은 값을 숫자로 변환한다.
        for (int i = 0; i < input.length(); i++) { // 리스트에 숫자 한 자리씩 저장한다.
            numbers.add(number % 10);
            number /= 10; // 한 자리씩 덜어낸다.
        }

        Collections.reverse(numbers); // 입력한 순서와 맞게 거꾸로 변환
    }
}

