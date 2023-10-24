package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private final List<Integer> secretNumber;

    public Computer() {
        secretNumber = new ArrayList<>();
        while (secretNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!secretNumber.contains(randomNumber)) {
                secretNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getSecretNumber() {
        return Collections.unmodifiableList(this.secretNumber);
    }
}
