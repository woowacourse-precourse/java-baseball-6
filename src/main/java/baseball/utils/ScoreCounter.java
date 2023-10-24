package baseball.utils;

import java.util.List;

public class ScoreCounter {
    public int countStrike(List<Integer> computer, List<Integer> user) {
        int count = 0;

        for (int i = 0; i < user.size(); i++) {
            if (isStrike(computer.get(i), user.get(i))) {
                count++;
            }
        }

        return count;
    }

    private boolean isStrike(Integer computerDigit, Integer userDigit) {
        return computerDigit.equals(userDigit);
    }

    public int countBall(List<Integer> computer, List<Integer> user) {
        int count = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (isBall(computer.get(i), user, i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isBall(Integer computerDigit, List<Integer> user, Integer index) {
        for (int i = 0; i < user.size(); i++) {
            if (i != index && user.get(i).equals(computerDigit)) {
                return true;
            }
        }

        return false;
    }

}
