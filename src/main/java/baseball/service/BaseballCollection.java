package baseball.service;

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
        validate(numbers);
        return mapToList(numbers);
    }

    // 기능: 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
    private List<Integer> createComputerBalls(NumberGenerator numberGenerator) {
        String numbers = createUniqueNumbers(numberGenerator);
        validate(numbers);
        return mapToList(numbers);
    }

    private List<Integer> mapToList(String target) {
        return target
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
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
        if(!usedNumbers.contains(number)) {
            target.append(number);
            usedNumbers.add(number);
        }
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

    private void validate(String number) {
        validateLength(number, DEFAULT_CAPACITY);
        validateNumeric(number);
        validateUnique(number);
        validateRange(number, BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
    }

    // 기능: length 자릿수로 입력해야 한다
    private void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(length + " 자릿수로 입력해야 합니다.");
        }
    }

    // 기능: 숫자만 입력해야 한다
    private void validateNumeric(String input) {
        boolean onlyNumeric = Pattern.matches("^[\\d]*$", input);
        if (!onlyNumeric) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    // 기능: 서로 다른 숫자로만 입력해야 한다
    private void validateUnique(String input) {
        Set<Character> uniqueNums = new HashSet<>();
        for (int numberIdx = 0; numberIdx < input.length(); numberIdx++) {
            uniqueNums.add(input.charAt(numberIdx));
        }
        if (uniqueNums.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해야 합니다.");
        }
    }

    private void validateRange(String baseBalls, int start, int end) {
        for (char baseball : baseBalls.toCharArray()) {
            if (!isInRange(start, end, baseball - '0')) {
                throw new IllegalArgumentException(String.format("%d~%d 범위의 숫자만 허용됩니다.", start, end));
            }
        }
    }

    private boolean isInRange(int start, int end, int baseball) {
        return start <= baseball && baseball <= end;
    }
}