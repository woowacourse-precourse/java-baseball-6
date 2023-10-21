package baseball;

import java.util.ArrayList;
import java.util.List;

final class Digits {
    private final List<Digit> digits = new ArrayList<>();

    Digits() {
        while (digits.size() < Size.THREE.num) {
            Digit randomDigit = new Digit();
            if (!digits.contains(randomDigit)) digits.add(randomDigit);
        }
    }
}
