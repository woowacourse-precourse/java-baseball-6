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

    //TODO : 정적팩터리로?
    Digits(String input) {
        for (int i = 0; i < input.length(); i++) {
            Digit digit = new Digit(input.charAt(i));
            if(digits.contains(digit)) throw new IllegalArgumentException();
            digits.add(digit);
        }
    }

    //TODO : strike점수가 빠져야함
    int countBall(Digits target) {
        int ballCount = 0;
        for (Digit it : target.digits) {
            if (digits.contains(it)) ballCount++;
        }
        return ballCount;
    }
}
