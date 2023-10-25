package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    /**
     * 사용자가 입력한 정수를 정수 리스트로 관리한다.
     */
    private final List<Integer> numbers;

    /**
     * 입력받은 값이 정수인지 검증하고, List에 저장한다.
     *
     * @param input 사용자가 입력한 정수 문자열
     */
    public User(String input) {
        validationTextLength(input); // 입력 값의 길이가 3인지 확인

        // 입력한 숫자를 분할하여 저장한다.
        List<Integer> inNumbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Number number = new Number(input.charAt(i));
            inNumbers.add(number.getNumber());
        }
        validationDuplication(inNumbers); // 중복된 값이 있는지 확인한다.

        this.numbers = inNumbers;
    }

    /**
     * 중복된 값이 있는지 확인한다.
     *
     * @param numbers 중복 검사를 할 문자열
     */
    private void validationDuplication(List<Integer> numbers) {
        // 중복을 허용하지 않는 Set 자료구조를 사용한다.
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) { // 크기를 비교한다.
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력 값의 길이가 3인지 확인한다.
     *
     * @param input 길이를 검증할 문자열
     */
    private void validationTextLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 유저가 입력한 값을 반환한다.
     *
     * @return 사용자가 입력한 정수가 포함된 리스트 반환
     */
    public List<Integer> getNumbers() {
        return numbers;
    }
}

