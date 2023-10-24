package baseball.service;

import java.util.List;

public class Hint {
    public int getStrikeCount(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            int num = user.get(i);
            if (!computer.get(i).equals(user.get(i)) && computer.contains(num)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
