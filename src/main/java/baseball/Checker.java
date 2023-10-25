package baseball;

import java.util.List;

public class Checker {
    private List<Integer> computerNumber;
    private List<Integer> playerNumber;
    private boolean used[];
    private int strike;
    private int ball;

    public Checker(List<Integer> computerNumber, List<Integer> playerNumber, boolean[] used) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
        this.used = used;
        this.strike = 0;
        this.ball = 0;
    }

    public boolean checkAnswer() {
        for (int i = 0; i < 3; ++i) {
            if (!isStrike(i, i)) {
                countBall(i);
            }
        }
        return (strike == 3);
    }

    public boolean isStrike(int computerIdx, int playerIdx) {
        if (computerNumber.get(computerIdx).equals(playerNumber.get(playerIdx))) {
            strike++;
            return true;
        }
        return false;
    }

    public void countBall(int playerIdx) {
        if (used[playerNumber.get(playerIdx)]) {
            ball++;
        }
    }
}
