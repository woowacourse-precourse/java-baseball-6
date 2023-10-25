package baseball;

import java.util.List;
import java.util.Objects;

public class Compare {
    static void List_compare(List<Integer> computer, List<Integer> user, int[] result) {
        int ball = 0;
        int strike = 0;
        // 비교하는 부분
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(computer.get(i), user.get(j))) {
                    if (i == j) {
                        strike++;
                        break;
                    }
                    ball++;
                }
            }
        }
        result[0] = ball;
        result[1] = strike;
    }
}