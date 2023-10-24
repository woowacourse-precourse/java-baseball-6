package baseball;

import java.util.List;

public class Logic {
    public int countStrikes(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countBalls(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }
}
