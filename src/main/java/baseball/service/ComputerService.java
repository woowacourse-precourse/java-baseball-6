package baseball.service;

import baseball.domain.*;

import static baseball.domain.Baseballs.*;

public class ComputerService {

    private final Computer computer;
    private final Player player;

    public ComputerService(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void setup() {
        computer.setUp();
    }

    public int calculateBallCount() {
        return countBalls();
    }

    public int calculateStrikeCount() {
        return countStrikes();
    }

    private int countBalls() {
        int ballCount = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isBall(index)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(int index) {
        return !isStrike(index) && containsBaseball(index);
    }

    private int countStrikes() {
        int strikeCount = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isStrike(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrike(int index) {
        Integer computerBaseball = computer.getBaseballs().getBall(index);
        Integer playerBaseball = player.getBaseballs().getBall(index);
        return computerBaseball.equals(playerBaseball);
    }

    private boolean containsBaseball(int ballIndex) {
        return computer.getBaseballs().contains(player.getBaseballs().getBall(ballIndex));
    }
}
