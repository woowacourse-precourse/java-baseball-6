package baseball.computer.judgement;

import java.util.List;

public class JudgeResult {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private int strikeCount = 0;
    private int ballCount = 0;

    public String getResult(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        judgeBalls(playerNumbers, computerNumbers);
        
        String ballCount = getBallCount();

        strikeCount = 0;
        this.ballCount = 0;
        
        return ballCount;
    }

    private String getBallCount() {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        }
        if (strikeCount == 0) {
            return ballCount + BALL;
        }
        if (ballCount == 0) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    private void judgeBalls(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        BallJudgement ballJudgement = new BallJudgement(computerNumbers);
        
        for (int i = 0; i < 3; i++) {
            BallStatus ballStatus = ballJudgement.judgeBall(new Ball(playerNumbers.get(i), i + 1));
            countBallStatus(ballStatus);
        }
    }

    private void countBallStatus(BallStatus ballStatus) {
        switch (ballStatus) {
            case STRIKE -> strikeCount++;
            case BALL -> ballCount++;
        }
    }
}
