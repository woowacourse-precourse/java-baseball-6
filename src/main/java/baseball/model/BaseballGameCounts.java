package baseball.model;

import java.util.Arrays;
import java.util.List;

public class BaseballGameCounts {

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    private final List<Integer> counts = Arrays.asList(0, 0);

    public BaseballGameCounts(ComputerNumber computer, UserNumber user) {
        this.checkStrikes(computer, user);
        this.checkBalls(computer, user);
    }

    private void checkStrikes(ComputerNumber computer, UserNumber user) {
        for (int idx = 0; idx < user.getUserNumber().size(); idx++) {
            addStrikeCounts(computer, user, idx);
        }
    }

    private void addStrikeCounts(ComputerNumber computer, UserNumber user, Integer idx) {
        if (user.getUserNumber().get(idx).equals(computer.getComputerNumber().get(idx))) {
            counts.set(STRIKE, counts.get(STRIKE) + 1);
        }
    }

    private void checkBalls(ComputerNumber computer, UserNumber user) {
        Integer ballCounts = 0;
        for (Integer userNumberDigit : user.getUserNumber()) {
            ballCounts = addBallCounts(computer, userNumberDigit, ballCounts);
        }

        ballCounts -= counts.get(STRIKE);
        counts.set(BALL, ballCounts);
    }

    private Integer addBallCounts(ComputerNumber computer, Integer userNumberDigit, Integer ballCounts) {
        if (computer.getComputerNumber().contains(userNumberDigit)) {
            ballCounts++;
        }
        return ballCounts;
    }

    public boolean isWinCondition() {
        return counts.get(STRIKE).equals(3);
    }


    public List<Integer> getCounts() {
        return counts;
    }

}
