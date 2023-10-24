package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Answer {
    private static final int LENGTH = 3;
    private static final String REGEX = "\\d{" + LENGTH + "}";
    private final String value;

    Answer(final String input) {
        validate(input);
        this.value = input;
    }

    public Integer getLength() {
        return LENGTH;
    }

    public String getValue() {
        return value;
    }

    // 정답 숫자 생성
    public static Answer createCorrectAnswer() {
        String distinctDigits = createUniqueDigits();
        return new Answer(distinctDigits);
    }

    // 입력 숫자 유효성 검사
    private void validate(final String input) {
        validateFormat(input);
        validateAnswerUnique(input);
    }

    private void validateFormat(final String num) {
        if(!num.matches(REGEX)) throw new IllegalArgumentException(Message.INVALID_INPUT);
    }

    private void validateAnswerUnique(final String input) {
        Set<Character> digits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            boolean uniqueDigit = digits.add(digit);
            if(!uniqueDigit) throw new IllegalArgumentException(Message.INVALID_INPUT);
        }
    }

    // 각 자리가 중복되지 않는 세 자리 숫자 문자열 생성
    private static String createUniqueDigits() {
        List<Integer> digits = new LinkedList<>();
        while (digits.size() < LENGTH) {
            Integer digit = Randoms.pickNumberInRange(1, 9);
            if(!digits.contains(digit)) digits.add(digit);
        }
        return digits.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}