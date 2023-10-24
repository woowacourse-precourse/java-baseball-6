package baseball.service.domain;

import static baseball.exception.ExceptionMessage.NOT_NUMERIC;
import static baseball.exception.ExceptionMessage.NOT_UNIQUE;
import static baseball.exception.ExceptionMessage.OUT_OF_LENGTH;
import static baseball.exception.ExceptionMessage.OUT_OF_RANGE;
import static baseball.service.domain.BaseballConstants.BASEBALL_END_NUMBER;
import static baseball.service.domain.BaseballConstants.BASEBALL_START_NUMBER;
import static baseball.service.domain.BaseballConstants.DEFAULT_CAPACITY;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseballCollection {
    private final List<Integer> baseball;

    private BaseballCollection(NumberGenerator numberGenerator) {
        this.baseball = createComputerBalls(numberGenerator);
    }

    private BaseballCollection(String playerInput) {
        this.baseball = createPlayerBalls(playerInput);
    }

    public static BaseballCollection ofComputerBaseball(NumberGenerator numberGenerator) {
        return new BaseballCollection(numberGenerator);
    }

    public static BaseballCollection ofPlayerBaseball(String playerInput) {
        return new BaseballCollection(playerInput);
    }

    // 기능: 사용자의 공을 입력 받고 생성한다
    private List<Integer> createPlayerBalls(String numbers) {
        return createValidBaseballs(numbers);
    }

    // 기능: 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
    private List<Integer> createComputerBalls(NumberGenerator numberGenerator) {
        String numbers = createUniqueNumbers(numberGenerator);
        return createValidBaseballs(numbers);
    }

    private String createUniqueNumbers(NumberGenerator numberGenerator) {
        StringBuilder uniqueNumbers = new StringBuilder();
        Stream.generate(numberGenerator::generate)
                .distinct()
                .limit(3)
                .forEach(uniqueNumbers::append);
        return uniqueNumbers.toString();
    }

    private List<Integer> createValidBaseballs(String number) {
        List<Integer> baseballs = Arrays.stream(number.split(""))
                .map(this::parseToInt)
                .distinct()
                .collect(Collectors.toList());
        validate(number, baseballs);
        return baseballs;
    }

    private void validate(String number, List<Integer> baseballs) {
        validateLength(baseballs);
        validateUniqueNumbers(baseballs, number);
        validateRange(baseballs);
    }

    private void validateLength(List<Integer> baseballs) {
        if (baseballs.size() != DEFAULT_CAPACITY) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.getError(DEFAULT_CAPACITY, baseballs.size()));
        }
    }

    private void validateUniqueNumbers(List<Integer> baseballs, String number) {
        if (baseballs.size() != number.length()) {
            throw new IllegalArgumentException(NOT_UNIQUE.getError(baseballs));
        }
    }

    private void validateRange(List<Integer> baseballs) {
        for (Integer baseball : baseballs) {
            if (!isInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER, baseball)) {
                throw new IllegalArgumentException(OUT_OF_RANGE.getError(baseball));
            }
        }
    }

    private int parseToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC.getError(target), e);
        }
    }

    private boolean isInRange(int start, int end, int baseball) {
        return start <= baseball && baseball <= end;
    }

    public int calculateStrikeCount(BaseballCollection playerBalls) {
        return (int) IntStream.range(0, DEFAULT_CAPACITY)
                .filter(index -> isStrike(this.baseball.get(index), playerBalls.baseball.get(index)))
                .count();
    }

    // 기능: 같은 수가 다른 자리에 있는 볼의 개수 세기
    public int calculateBallCount(BaseballCollection playerBalls) {
        return (int) IntStream.range(0, DEFAULT_CAPACITY)
                .filter(index -> isBall(this.baseball.get(index), playerBalls.baseball.get(index)))
                .count();
    }

    private boolean isStrike(int computerBall, int playerBall) {
        return this.baseball.contains(playerBall) && playerBall == computerBall;
    }

    private boolean isBall(int computerBall, int playerBall) {
        return this.baseball.contains(playerBall) && playerBall != computerBall;
    }
}