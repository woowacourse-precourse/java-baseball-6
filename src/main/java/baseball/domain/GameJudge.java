package baseball.domain;

import static baseball.global.constant.BaseballGameConstant.ALL_STRIKE;

import java.util.List;

public class GameJudge {
    private final Player player;
    private final Computer computer;
    private int ball;
    private int strike;

    public GameJudge(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
        this.ball = 0;
        this.strike = 0;
    }

    public static GameJudge from(Player player, Computer computer) {
        return new GameJudge(player, computer);
    }

    public void analyzeNumbers() {
        for (int i = 0; i < 3; i++) {
            int playerNumber = player.getNumberOf(i);
            int computerNumber = computer.getNumberOf(i);

            if (playerNumber == computerNumber) {
                ++strike;
            } else if (computer.containOf(playerNumber)) {
                ++ball;
            }
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
