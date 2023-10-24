package baseball.Check;

import java.util.List;
import java.util.Objects;

public class Strike {
    public static int count(List<Integer> user, List<Integer> com) {

        int str = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(user.get(i), com.get(i))) {
                str++;
            }
        }
        return str;
    }
}
