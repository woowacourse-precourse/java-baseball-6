package baseball.core;

import java.util.List;

public class Core {
    public boolean isStrike(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        return computerNumber.get(index).equals(userNumber.get(index));
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (isStrike(computerNumber, userNumber, i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isBall(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        if (isStrike(computerNumber, userNumber, index)) {
            return false;
        }
        for (int cur = 0; cur < userNumber.size(); cur++) {
            if (cur == index) {
                continue;
            }
            if (computerNumber.get(cur).equals(userNumber.get(index))) {
                return true;
            }
        }
        return false;
    }

    public int countBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (isBall(computerNumber, userNumber, i)) {
                count++;
            }
        }
        return count;
    }
}
