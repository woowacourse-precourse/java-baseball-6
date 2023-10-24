package baseball;

import java.util.List;

public class Compare {
    public int num_equal(List<Integer> computer, List<Integer> player) {
        int equal = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(player.get(i))) {
                equal += 1;
            }
        }
        return equal;
    }

    public int num_strike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }
}
