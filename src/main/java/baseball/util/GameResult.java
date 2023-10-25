package baseball.util;

import baseball.game.BallCount;

import java.util.List;

public class GameResult {
    private static final String NOTHING = "낫싱";
    private final BallCount ballCount = new BallCount();

    public void calculateResult(String userGuess, List<Integer> computerNumbers) {
        ballCount.reset();

        for (int i = 0; i < userGuess.length(); i++) {
            int number = Character.getNumericValue(userGuess.charAt(i));

            if (number == computerNumbers.get(i)) {
                ballCount.addStrike();
            } else if (computerNumbers.contains(number)) {
                ballCount.addBall();
            }
        }
    }

    public String getResultMessage() {
        if (ballCount.getBallCount() == 0 && ballCount.getStrikeCount() == 0) {
            return NOTHING;
        }

        StringBuilder result = new StringBuilder();
        if (ballCount.getBallCount() != 0) {
            result.append(ballCount.getBallCount()).append("볼 ");
        }

        if (ballCount.getStrikeCount() != 0) {
            result.append(ballCount.getStrikeCount()).append("스트라이크");
        }

        return result.toString();
    }

    public boolean isGameWon() {
        return ballCount.isAllStrikes(3);
    }
}