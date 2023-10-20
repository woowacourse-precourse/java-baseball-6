package baseball;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    List<Digit> digits;

    public Digits() {
        digits = new ArrayList<>();
        while (digits.size() < Size.THREE.num) {
            Digit randomDigit = new Digit();
            if (!digits.contains(randomDigit)) digits.add(randomDigit);
        }
    }
}
