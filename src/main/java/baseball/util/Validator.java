package baseball.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Validator {

    public Validator() {
        // initialize
    }

    public void checkValid(String input, int size) {
        isValidSize(input, size);
        isInteger(input);
        isDuplicate(input);
    }

    public void checkValid(String input, String retry, String exit) {
        isValidNumber(input, retry, exit);
    }

    private void isValidSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException("올바른 자리 수의 값을 입력하세요.");
        }
    }

    private void isInteger(String input) throws IllegalArgumentException {
        for (char c : input.toCharArray()) {
            if (c <= '0' || c > '9') {
                throw new IllegalArgumentException("1부터 9까지의 수를 입력하세요.");
            }
        }
    }

    private void isDuplicate(String input) throws IllegalArgumentException {
        List<Integer> inputNumbers = new ArrayList<>();
        char[] charNumbers = input.toCharArray();
        for (char charNumber : charNumbers) {
            inputNumbers.add((int) charNumber);
        }
        if (inputNumbers.size() != new HashSet<>(inputNumbers).size()) {
            throw new IllegalArgumentException("중복된 숫자를 포함하고 있습니다.");
        }
    }

    private void isValidNumber(String input, String retry, String exit) throws IllegalArgumentException {
        if (!input.equals(retry) && !input.equals(exit)) {
            throw new IllegalArgumentException("1(재시작)과 2(종료) 중 하나의 수를 입력하세요.");
        }
    }
}
