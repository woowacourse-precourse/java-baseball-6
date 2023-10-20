package baseball;

import java.util.List;

public class Judgement {
    // 기능: 힌트 얻기
    public String getHint(List<Integer> computerBalls, List<Integer> playerBalls) {
        if (isNothing(computerBalls, playerBalls)) {
            return "낫싱";
        }
        int strikeCount = getStrikeCount(computerBalls, playerBalls);
        int ballCount = getBallCount(computerBalls, playerBalls);
        return getResult(ballCount, strikeCount);
    }

    // 기능: 같은 수가 전혀 없으면 낫싱
    private boolean isNothing(List<Integer> computerBalls, List<Integer> playerBalls) {
        return computerBalls.stream()
                .noneMatch(playerBalls::contains);
    }

    // 기능: 같은 수가 같은 자리에 있는 스트라이크의 개수 세기
    private int getStrikeCount(List<Integer> computerBalls, List<Integer> playerBalls) {
        int strikeCount = 0;
        for (int ballPosition = 0; ballPosition < computerBalls.size(); ballPosition++) {
            int playerBall = playerBalls.get(ballPosition);
            int computerBall = computerBalls.get(ballPosition);
            if (computerBalls.contains(playerBall) && playerBall == computerBall) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    // 기능: 같은 수가 다른 자리에 있는 볼의 개수 세기
    private int getBallCount(List<Integer> computerBalls, List<Integer> playerBalls) {
        int ballCount = 0;
        for (int ballPosition = 0; ballPosition < computerBalls.size(); ballPosition++) {
            int playerBall = playerBalls.get(ballPosition);
            int computerBall = computerBalls.get(ballPosition);
            if (computerBalls.contains(playerBall) && playerBall != computerBall) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private String getResult(int ballCount, int strikeCount) {
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
