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
        for (int i = 0; i < 3; i++) {
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
            result = "낫싱";
        } else if (balls == 0) {
            result = strikes + "스트라이크";
        } else if (strikes == 0) {
            result = balls + "볼";
        } else {
            result = balls + "볼 " + strikes + "스트라이크";
        }

        System.out.println(result);
    }

    public boolean isThreeStrike() {
        return strikes == 3;
    }
}
