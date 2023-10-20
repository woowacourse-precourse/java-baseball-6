package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Answer {
    private static final int LENGTH = 3;
    private final String value;

    Answer() {
        this.value = createUniqueDigits();
    }

    Answer(final String input) {
        validate(input);
        this.value = input;
    }

    public int getLength() {
        return LENGTH;
    }

    public String getValue() {
        return value;
    }

    public static void validate(final String input) {
        try {
            validateNumString(input);
            validateAnswerLength(input);
            validateAnswerUnique(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private String createUniqueDigits() {
        List<Integer> numList = Randoms.pickUniqueNumbersInRange(0, 9, LENGTH);
        if(numList.get(0) == 0) {
            Collections.swap(numList, 0, 1);
        }
        return numList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static void validateNumString(final String num) {
        for (char ch : num.toCharArray()) {
            if(!num.matches("//d+")) throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private static void validateAnswerUnique(final String input) {
        int size = input.length();
        int uniqueSize = input.chars()
                .mapToObj(c -> ((char) c))
                .collect(Collectors.toSet())
                .size();
        if (size != uniqueSize) throw new IllegalArgumentException("각 자리의 숫자는 unique해야 합니다");
    }

    private static void validateAnswerLength(final String input) {
        if (input.length() != LENGTH) throw new IllegalArgumentException("자릿수가 올바르지 않습니다");
    }
}