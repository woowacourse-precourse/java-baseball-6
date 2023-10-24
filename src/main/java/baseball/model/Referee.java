package baseball.model;

import baseball.util.Constants;

public class Referee {
    private final ComputerNumber computerNumber;
    private final PlayerNumber playerNumber;

    public Referee(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    public JudgeResult judgeBallCount() {
        JudgeResult judgeResult = new JudgeResult();
        for (int i = 0; i < Constants.BALL_LENGTH; i++) {
            BallCount ballCount = BallCount.judge(numberMatching(i), positionMatching(i));
            judgeResult.addResult(ballCount);
        }
        return judgeResult;
    }

    private boolean numberMatching(int position) {
        return computerNumber.hasNumber(playerNumber.getNumberByPosition(position));
    }

    private boolean positionMatching(int position) {
        return computerNumber.getNumberByPosition(position).equals(playerNumber.getNumberByPosition(position));
    }

}
