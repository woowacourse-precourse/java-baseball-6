package baseball.service;

import java.util.List;
import java.util.Objects;

public class CompareNumber {

    public static int CountStrike(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computer.get(i), user.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static int CountBall(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i)) && !Objects.equals(computer.get(i), user.get(i))) {
                count++;
            }
        }
        return count;
    }

}

