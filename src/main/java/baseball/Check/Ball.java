package baseball.Check;

import java.util.List;
import java.util.Objects;

public class Ball {
    public static int count(List<Integer> user, List<Integer> com) {

        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (!Objects.equals(user.get(i), com.get(i)) && user.contains(com.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
