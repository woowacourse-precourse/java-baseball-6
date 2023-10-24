package baseball.service;

import static baseball.Constants.INITIAL_COUNT;
import static baseball.Constants.MAX_INDEX_SIZE;
import static baseball.Constants.START_INDEX_NUM;

import java.util.List;

public class Hint {
    public int getStrikeCount(List<Integer> computer, List<Integer> user) {
        int strikeCount = INITIAL_COUNT;
        for (int i = START_INDEX_NUM; i < MAX_INDEX_SIZE; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(List<Integer> computer, List<Integer> user) {
        int ballCount = INITIAL_COUNT;
        for (int i = START_INDEX_NUM; i < MAX_INDEX_SIZE; i++) {
            int num = user.get(i);
            if (!computer.get(i).equals(user.get(i)) && computer.contains(num)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
