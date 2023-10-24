package baseball.utils;

import java.util.List;

public class ScoreCounter {
    public int countStrike(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countBall(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (i != j && computer.get(i).equals(user.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}
