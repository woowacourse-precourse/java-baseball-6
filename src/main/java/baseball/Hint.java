package baseball;

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
}
