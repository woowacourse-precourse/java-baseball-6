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
        if (isNothing()) {
            result = Constants.NOTHING;
        } else if (hasOnlyBall()) {
            result = balls + Constants.BALL;
        } else if (hasOnlyStrike()) {
            result = strikes + Constants.STRIKE;
        } else {
            result = balls + Constants.BALL + " " + strikes + Constants.STRIKE;
        }

        Output.printResult(result);
    }

    public boolean isThreeStrike() {
        return strikes == 3;
    }

    private boolean isNothing() {
        return balls == 0 && strikes == 0;
    }

    private boolean hasOnlyBall() {
        return strikes == 0;
    }

    private boolean hasOnlyStrike() {
        return balls == 0;
    }
}
