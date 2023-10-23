package baseball.service;

public class Judgement {
    // 기능: 힌트 얻기
    public String calculateHint(BaseballCollection computerBalls, BaseballCollection playerBalls) {
        if (computerBalls.isNothing(playerBalls)) {
            return "낫싱";
        }
        int strikeCount = computerBalls.calculateStrikeCount(playerBalls);
        int ballCount = computerBalls.calculateBallCount(playerBalls);
        return appendingResult(ballCount, strikeCount);
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