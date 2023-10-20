package baseball.entity;

import java.util.*;

class Balls {

    private static final int MAX_BALLS_SIZE = 3;
    private static final String UNKNOWN_BALLS_MESSAGE = "알 수 없는 숫자 목록(null)으로 객체를 생성할 수 없습니다.";
    private static final String NULL_INCLUDED_BALLS_MESSAGE = "알 수 없는 숫자(null)가 포함되어 있는 목록으로 객체를 생성할 수 없습니다.";
    private static final String EXCEED_SIZE_MESSAGE = MAX_BALLS_SIZE + "개의 숫자를 선택해주세요.";
    private static final String DUPLICATION_BALLS_MESSAGE = "중복된 숫자는 허용되지 않습니다.";

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls from(List<Integer> numbers) {
        checkNumbersNonNull(numbers);
        checkNumbersIncludeNull(numbers);
        checkNumbersSize(numbers);
        checkNumbersDuplication(numbers);

        return new Balls(mapToBall(numbers));
    }

    private static void checkNumbersNonNull(List<Integer> numbers) {
        Optional.ofNullable(numbers)
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_BALLS_MESSAGE));
    }

    private static void checkNumbersIncludeNull(List<Integer> numbers) {
        boolean isInclude = numbers.stream()
                .map(Optional::ofNullable)
                .anyMatch(Optional::isEmpty);

        if (isInclude) {
            throw new IllegalArgumentException(NULL_INCLUDED_BALLS_MESSAGE);
        }
    }

    private static void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != MAX_BALLS_SIZE) {
            throw new IllegalArgumentException(EXCEED_SIZE_MESSAGE);
        }
    }

    private static void checkNumbersDuplication(List<Integer> numbers) {
        int uniqueSize = numbers.stream()
                .distinct()
                .toList()
                .size();

        if (numbers.size() != uniqueSize) {
            throw new IllegalArgumentException(DUPLICATION_BALLS_MESSAGE);
        }
    }

    private static List<Ball> mapToBall(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (int position = 1; position <= MAX_BALLS_SIZE; position++) {
            balls.add(Ball.of(numbers.get(position - 1), position));
        }

        return Collections.unmodifiableList(balls);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
