package baseball;

import baseball.constant.GameMessage;
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

    public void printResult() {
        if (strike == 3) {
            System.out.println(strike + GameMessage.STRIKE);
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + GameMessage.BALL + " " + strike + GameMessage.STRIKE);
        } else if (strike > 0 & ball == 0) {
            System.out.println(strike + GameMessage.STRIKE);
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + GameMessage.BALL);
        } else if (strike == 0 && ball == 0) {
            System.out.println(GameMessage.NOTHING);
        }
    }
}
