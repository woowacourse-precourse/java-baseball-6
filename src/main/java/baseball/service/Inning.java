package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Score;

public class Inning {
    int NUMBER_SIZE = 3;
    Computer computer;
    Player player;
    Score score;

    public Score doInning(Computer computer) {
        this.computer = computer;
        this.player = new Player();
        this.score = new Score();

        calculateScore();

        return score;
    }

    private void calculateScore() {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (isStrike(i)) {
                score.addStrike();
            } else if (isBall(i)) {
                score.addBall();
            }
        }
    }

    private boolean isStrike(int i) {
        return computer.getNumbers().get(i) == player.getNumbers().get(i);
    }

    private boolean isBall(int i) {
        return computer.getNumbers().contains(player.getNumbers().get(i));
    }


}
