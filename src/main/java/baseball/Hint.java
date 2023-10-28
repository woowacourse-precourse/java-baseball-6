package baseball;

import java.util.List;

public class Hint {
    public int ballCount = 0;
    public int strikeCount = 0;
    public static final int endCount = 3;

    public void checkBall(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                ballCount++;
            }
        }
    }

    public void checkStrike(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }
        }
    }

    public void resetCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    public boolean checkEndGame() {
        if (strikeCount == endCount) {
            return true;
        }
        return false;
    }
}
