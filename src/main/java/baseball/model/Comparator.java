package baseball.model;

import java.util.List;

public class Comparator {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 2;
    private static final int GAME_FINISH_COUNT = 3;
    private int strike;
    private int ball;
    private Player player;
    private Computer computer;

    public Comparator(Player player, Computer computer) {
        this.strike = 0;
        this.ball = 0;
        this.player = player;
        this.computer = computer;
    }

    public void compare() {
        List<Integer> playerNumbers = player.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        for (int i = START_INDEX; i <= END_INDEX; i++)  {
            int playerNumber = playerNumbers.get(i);
            int computerNumber = computerNumbers.get(i);
            plusPoint(playerNumber, computerNumber);
        }
    }

    private void plusPoint(int playerNumber, int computerNumber) {
        if (playerNumber == computerNumber) {
            strike++;
            return;
        }
        if (computer.getNumbers().contains(playerNumber)) {
            ball++;
        }
    }

    public boolean isFinishGame() {
        if (strike == GAME_FINISH_COUNT) {
            return true;
        }
        return false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
