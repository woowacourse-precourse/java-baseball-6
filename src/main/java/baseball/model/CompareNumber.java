package baseball.model;

import java.util.List;

public class CompareNumber {
    public int countSameNumber(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public int countStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) != null && computer.get(i).equals(player.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }
}
