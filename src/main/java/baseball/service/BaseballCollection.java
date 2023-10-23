package baseball.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        Set<Integer> usedNumbers = new HashSet<>();
        while (doesNotExceedCapacity(uniqueNumbers)) {
            int number = numberGenerator.generate();
            appendIfUniqueNumber(number, uniqueNumbers, usedNumbers);
        }
        return uniqueNumbers.toString();
    }

    private boolean doesNotExceedCapacity(StringBuilder target) {
        return target.length() < DEFAULT_CAPACITY;
    }

    private void appendIfUniqueNumber(int number, StringBuilder target, Set<Integer> usedNumbers) {
        if (!usedNumbers.contains(number)) {
            target.append(number);
            usedNumbers.add(number);
        }
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
            throw new IllegalArgumentException("길이가 다른 입력입니다,");
        }
    }

    private void validateUniqueNumbers(List<Integer> baseballs, String number) {
        if (baseballs.size() != number.length()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private void validateRange(List<Integer> baseballs) {
        for (Integer baseball : baseballs) {
            if (!isInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER, baseball)) {
                throw new IllegalArgumentException("범위를 벗어난 숫자가 존재합니다.");
            }
        }
    }

    private int parseToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 존재합니다.", e);
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

    // 기능: 같은 수가 같은 자리에 있는 스트라이크의 개수 세기
    public int calculateStrikeCount(BaseballCollection playerBalls) {
        int strikeCount = 0;
        for (int ballPosition = 0; ballPosition < DEFAULT_CAPACITY; ballPosition++) {
            int playerBall = playerBalls.baseball.get(ballPosition);
            int computerBall = this.baseball.get(ballPosition);
            if (this.baseball.contains(playerBall) && playerBall == computerBall) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    // 기능: 같은 수가 다른 자리에 있는 볼의 개수 세기
    public int calculateBallCount(BaseballCollection playerBalls) {
        int ballCount = 0;
        for (int ballPosition = 0; ballPosition < DEFAULT_CAPACITY; ballPosition++) {
            int playerBall = playerBalls.baseball.get(ballPosition);
            int computerBall = this.baseball.get(ballPosition);
            if (this.baseball.contains(playerBall) && playerBall != computerBall) {
                ballCount++;
            }
        }
        return ballCount;
    }
}