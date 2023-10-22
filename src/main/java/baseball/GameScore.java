package baseball;

import java.util.List;

public class GameScore {

    private BallCount ballCount;
    private StrikeCount strikeCount;

    public GameScore() {
        this.ballCount = new BallCount();
        this.strikeCount = new StrikeCount();
    }

    public void checkStrike(List<Integer> gameNumber, List<Integer> answerNumber) {
        for (int i = 0; i < gameNumber.size(); i++) {
            int checkGameNumber = gameNumber.get(i);
            int checkAnswerNumber = answerNumber.get(i);
            if (checkGameNumber == checkAnswerNumber) {
                strikeCount.setStrike();
            }
        }
    }

    public void checkBall(List<Integer> gameNumber, List<Integer> answerNumber) {
        for (int i = 0; i < gameNumber.size(); i++) {
            int checkGameNumber = gameNumber.get(i);
            int checkAnswerNumber = answerNumber.get(i);
            if (gameNumber.contains(checkAnswerNumber) && (checkGameNumber != checkAnswerNumber)) {
                ballCount.setBall();
            }
        }
    }

    public int getStrikeCount() {
        return strikeCount.getStrike();
    }

    public int getBallCount() {
        return ballCount.getBall();
    }

}
