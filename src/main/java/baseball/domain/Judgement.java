package baseball.domain;

import java.util.List;

public class Judgement {

    public int countMatchingDigits(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i=0; i<player.size(); i++) {
            if (computer.contains(player.get(i))) {
                result++;
            }
        }
        return result;
    }

    public boolean isNumberInPosition(int positionNumber, int number) {
        return false;
    }
}
