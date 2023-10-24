package baseball.component;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Initializer {

    private Initializer() {}

    private static Initializer initializer;

    public static Initializer getInitializer() {
        if (initializer == null) {
            initializer = new Initializer();
        }
        return initializer;
    }

    public List<Integer> getNewNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int tmp = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(tmp)) {
                numbers.add(tmp);
            }
        }
        return numbers;
    }
}
