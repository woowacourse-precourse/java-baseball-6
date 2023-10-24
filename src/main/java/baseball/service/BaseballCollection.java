package baseball.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseballCollection {
    private final int DEFAULT_CAPACITY = 3;
    private final int BASEBALL_START_NUMBER = 1;
    private final int BASEBALL_END_NUMBER = 9;
    private final List<Integer> baseball;

    public BaseballCollection(NumberGenerator numberGenerator) {
        this.baseball = createComputerBalls(numberGenerator);
    }

    public BaseballCollection(String playerInput) {
        this.baseball = createPlayerBalls(playerInput);
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
        validateLength(baseballs);
        validateUniqueNumbers(baseballs, number);
        validateRange(baseballs);
        return baseballs;
    }

    private void validateLength(List<Integer> baseballs) {
        if (baseballs.size() != DEFAULT_CAPACITY) {
            throw new IllegalArgumentException(
                    String.format("길이 %d으로 입력해야 합니다. 현재 길이: %d", DEFAULT_CAPACITY, baseballs.size()));
        }
    }

    private void validateUniqueNumbers(List<Integer> baseballs, String number) {
        if (baseballs.size() != number.length()) {
            throw new IllegalArgumentException(String.format("%s에 중복된 숫자가 존재합니다.", baseballs));
        }
    }

    private void validateRange(List<Integer> baseballs) {
        for (Integer baseball : baseballs) {
            if (!isInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER, baseball)) {
                throw new IllegalArgumentException(String.format("%d은 범위를 벗어난 숫자입니다.", baseball));
            }
        }
    }

    private int parseToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s는 숫자가 아닌 문자입니다.", target), e);
        }
    }

    private boolean isInRange(int start, int end, int baseball) {
        return start <= baseball && baseball <= end;
    }

    // 기능: 같은 수가 전혀 없으면 낫싱
    public boolean isNothing(BaseballCollection playerBalls) {
        return this.baseball.stream()
                .noneMatch(playerBalls.baseball::contains);
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
        if (this.baseball.contains(playerBall) && playerBall == computerBall) {
            return true;
        }
        return false;
    }

    private boolean isBall(int computerBall, int playerBall) {
        if (this.baseball.contains(playerBall) && playerBall != computerBall) {
            return true;
        }
        return false;
    }
}