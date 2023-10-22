package baseball.ball.judgement;

import baseball.ball.Ball;
import baseball.ball.status.BallStatus;

import java.util.List;

public class JudgeResult {
    private int strike = 0;
    private int ball = 0;

    public String getResult(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        judgeBalls(playerNumbers, computerNumbers);
        
        String ballCount = getBallCount();

        strike = 0;
        ball = 0;
        
        return ballCount;
    }

    private String getBallCount() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
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
            case STRIKE -> strike++;
            case BALL -> ball++;
        }
    }
}
