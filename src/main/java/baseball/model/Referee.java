package baseball.model;

import baseball.util.Constants;

public class Referee {
    private final Computer computer;
    private final Player player;

    public Referee(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void judgeBallCount() {
        for (int i = 0; i < Constants.BALL_LENGTH; i++) {
            BallCount ballCount = BallCount.judge(numberMatching(i), positionMatching(i));
        }
    }

    private boolean numberMatching(int position) {
        return computer.hasNumber(player.getNumberByPosition(position));
    }

    private boolean positionMatching(int position) {
        return computer.getNumberByPosition(position) == player.getNumberByPosition(position);
    }

}
