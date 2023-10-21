package baseball;

import java.util.List;

public class Umpire {
    private String result;
    private int strikes;
    private int balls;

    public Umpire() {
        this.result = "";
        this.strikes = 0;
        this.balls = 0;
    }

    public void compareUserWithComputer(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes += 1;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls += 1;
            }
        }

        printResult();
    }

    private void printResult() {
        if (balls == 0 && strikes == 0) {
            result = Constants.NOTHING;
        } else if (balls == 0) {
            result = strikes + Constants.STRIKE;
        } else if (strikes == 0) {
            result = balls + Constants.BALL;
        } else {
            result = balls + Constants.BALL + " " + strikes + Constants.STRIKE;
        }

        System.out.println(result);
    }

    public boolean isThreeStrike() {
        return strikes == 3;
    }
}
