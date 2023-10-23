package baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballCollection {
    private final int DEFAULT_CAPACITY = 3;
    private final String NOTHING = "낫싱";
    private final List<Integer> baseball;
    private BaseballValidator baseballValidator = new BaseballValidator();

    public BaseballCollection(NumberGenerator numberGenerator) {
        this.baseball = createComputerBalls(numberGenerator);
    }

    public BaseballCollection(String playerInput) {
        this.baseball = createPlayerBalls(playerInput);
    }

    // 기능: 사용자의 공을 입력 받고 생성한다
    private List<Integer> createPlayerBalls(String number) {
        baseballValidator.validateBaseball(number);
        return number
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    // 기능: 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
    private List<Integer> createComputerBalls(NumberGenerator numberGenerator) {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < DEFAULT_CAPACITY) {
            int randomNumber = numberGenerator.generate();
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return computerBalls;
    }

    // 기능: 힌트 얻기
    public String getHint(BaseballCollection playerBalls) {
        if (isNothing(playerBalls)) {
            return NOTHING;
        }
        int strikeCount = calculateStrikeCount(playerBalls);
        int ballCount = calculateBallCount(playerBalls);
        return appendingResult(ballCount, strikeCount);
    }

    // 기능: 같은 수가 전혀 없으면 낫싱
    private boolean isNothing(BaseballCollection playerBalls) {
        return this.baseball.stream()
                .noneMatch(playerBalls.baseball::contains);
    }

    // 기능: 같은 수가 같은 자리에 있는 스트라이크의 개수 세기
    private int calculateStrikeCount(BaseballCollection playerBalls) {
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
    private int calculateBallCount(BaseballCollection playerBalls) {
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

    private String appendingResult(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();
        if (ballCount > 0) {
            result.append(String.format("%d볼 ", ballCount));
        }
        if (strikeCount > 0) {
            result.append(String.format("%d스트라이크", strikeCount));
        }
        return result.toString().trim();
    }
}
