package baseball;

import java.util.List;

public class Result {
    private int balls = 0;
    private int strikes = 0;

    public Result(List<Integer> computer, List<Integer> player) {
        calculate(computer, player);
    }

    private void calculate(List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strikes++;
            } else if (computer.contains(player.get(i))) {
                balls++;
            }
        }
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }
}
