package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    /**
     * 사용자가 입력한 숫자를 정수 리스트로 관리한다.
     */
    private final List<Integer> numbers;

    /**
     * 입력받은 값이 정수인지 검증하고, List에 저장한다.
     *
     * @param input
     */
    public User(String input) {
        List<Integer> inNumbers = new ArrayList<>();
        Number inNumber = new Number(input); // 입력값 숫자 여부 확인
        validationLength(input); // 입력 값의 길이가 3인지 확인

        int number = inNumber.getNumber(); // 입력 받은 숫자를 가져온다.
        for (int i = 0; i < input.length(); i++) { // 리스트에 숫자 한 자리씩 저장한다.
            inNumbers.add(number % 10);
            number /= 10; // 한 자리씩 덜어낸다.
        }

        Collections.reverse(inNumbers); // 입력한 순서와 맞게 거꾸로 변환

        validationDuplication(inNumbers); // 중복된 값이 있는지 확인한다.

        this.numbers = inNumbers;
    }

    /**
     * 중복된 값이 있는지 확인한다.
     *
     * @param input
     */
    private void validationDuplication(List<Integer> numbers) {
        // 중복을 허용하지 않는 Set 자료구조를 사용한다.
        Set<Integer> numbersSet = new HashSet<>(numbers);

        // 크기를 비교한다.
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
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

