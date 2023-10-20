package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    /**
     * 사용자가 입력한 숫자를 정수 리스트로 관리한다.
     */
    private final List<Integer> numbers = new ArrayList<>();

    /**
     * 입력받은 값이 정수인지 검증하고, List에 저장한다.
     *
     * @param input
     */
    public User(String input) {
        Number inNumber = new Number(input); // 입력값 숫자 여부 확인
        validationLength(input); // 입력 값의 길이가 3인지 확인

        int number = inNumber.getNumber(); // 입력 받은 숫자를 가져온다.
        for (int i = 0; i < input.length(); i++) { // 리스트에 숫자 한 자리씩 저장한다.
            numbers.add(number % 10);
            number /= 10; // 한 자리씩 덜어낸다.
        }

        Collections.reverse(numbers); // 입력한 순서와 맞게 거꾸로 변환
    }

    /**
     * 입력 값의 길이가 3인지 확인한다.
     *
     * @param input
     */
    private void validationLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 유저가 입력한 값을 반환한다.
     *
     * @return
     */
    public List<Integer> getNumbers() {
        return numbers;
    }
}

