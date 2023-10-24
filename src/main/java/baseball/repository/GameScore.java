package baseball.repository;

import baseball.dto.BallScore;
import baseball.dto.StrikeScore;
import java.util.List;

public class GameScore {
    private final BallScore ballScore;
    private final StrikeScore strikeScore;

    public GameScore() {
        this.ballScore = new BallScore();
        this.strikeScore = new StrikeScore();
    }

    private void checkStrike(List<Integer> gameNumber, List<Integer> answerNumber) {
        int strikeCount = 0;
        for (int i = 0; i < gameNumber.size(); i++) {
            int checkGameNumber = gameNumber.get(i);
            int checkAnswerNumber = answerNumber.get(i);
            if (checkGameNumber == checkAnswerNumber) {
                strikeCount++;
            }
        }
        strikeScore.setStrikeScore(strikeCount);
    }

    private void checkBall(List<Integer> gameNumber, List<Integer> answerNumber) {
        int ballCount = 0;
        for (int i = 0; i < gameNumber.size(); i++) {
            int checkGameNumber = gameNumber.get(i);
            int checkAnswerNumber = answerNumber.get(i);
            if (gameNumber.contains(checkAnswerNumber) && (checkGameNumber != checkAnswerNumber)) {
                ballCount++;
            }
        }
        ballScore.setBallScore(ballCount);
    }

    public void checkGameScore(List<Integer> gameNumber, List<Integer> answerNumber) {
        checkStrike(gameNumber, answerNumber);
        checkBall(gameNumber, answerNumber);
    }

    public int getStrikeCount() {
        return strikeScore.getStrikeScore();
    }

    public int getBallCount() {
        return ballScore.getBallScore();
    }

}
