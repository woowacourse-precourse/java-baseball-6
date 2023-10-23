package baseball.model;

import java.util.Arrays;
import java.util.List;

public class BaseballGameCounts {

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    private final List<Integer> counts = Arrays.asList(0, 0);

    public BaseballGameCounts(ComputerNumber computer, UserNumber user) {
        for (int idx = 0; idx < user.getUserNumber().size(); idx++) {
            if (user.getUserNumber().get(idx).equals(computer.getComputerNumber().get(idx))) {
                counts.set(STRIKE, counts.get(STRIKE) + 1);
            }
        }

        int ballCounts = 0;
        for (Integer idx : user.getUserNumber()) {
            if (computer.getComputerNumber().contains(idx)) {
                ballCounts++;
            }
        }
        ballCounts -= counts.get(STRIKE);
        counts.set(BALL, ballCounts);
    }

    public boolean isWinCondition() {
        return counts.get(STRIKE).equals(3);
    }

    public void resetCounts() {
        counts.set(BALL, 0);
        counts.set(STRIKE, 0);
    }

    public List<Integer> getCounts() {
        return counts;
    }

}
