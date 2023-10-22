package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameCounts {

    private static final int STRIKE = 0;
    private static final int BALL = 1;

    private final List<Integer> counts = new ArrayList<>();

    protected BaseballGameCounts() {
    }

    public static BaseballGameCounts createBaseballGameCounts(ComputerNumber computer, UserNumber user) {

        BaseballGameCounts baseballGameCounts = new BaseballGameCounts();
        int ballCounts = 0;
        for (Integer idx : user.getUserNumber()) {
            if (computer.getComputerNumber().contains(idx)) {
                ballCounts++;
            }
        }
        ballCounts -= baseballGameCounts.getCounts().get(STRIKE);
        if (ballCounts > 0) {
            baseballGameCounts.counts.set(BALL, ballCounts);
        }

        int strickCounts = 0;
        for (int idx = 0; idx < user.getUserNumber().size(); idx++) {
            if (user.getUserNumber().get(idx).equals(computer.getComputerNumber().get(idx))) {
                strickCounts++;
            }
        }
        if (strickCounts > 0) {

            baseballGameCounts.counts.set(STRIKE, strickCounts);
        }
        return baseballGameCounts;
    }

    public boolean isWinCondition() {
        return this.counts.get(STRIKE) == 3;
    }

    public void resetCounts() {
        counts.set(STRIKE, 0);
        counts.set(BALL, 1);
    }

    public List<Integer> getCounts() {
        return this.counts;
    }

}
