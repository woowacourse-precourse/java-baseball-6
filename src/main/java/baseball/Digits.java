package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

final class Digits {
    private List<Digit> digits;

    private Digits() {
    }

    static Digits generateRandomDigits() {
        Digits randomDigits = new Digits();
        randomDigits.digits = new ArrayList<>();
        while (randomDigits.digits.size() < Size.THREE.num) {
            Digit randomDigit = new Digit();
            if (!randomDigits.digits.contains(randomDigit)) randomDigits.digits.add(randomDigit);
        }
        return randomDigits;
    }

    static Digits generateFixedDigits(String input) {
        if(input.length() != Size.THREE.num) throw new IllegalArgumentException();
        Digits fixedDigits = new Digits();
        fixedDigits.digits = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Digit digit = new Digit(input.charAt(i) - '0');
            if (fixedDigits.digits.contains(digit)) throw new IllegalArgumentException();
            fixedDigits.digits.add(digit);
        }
        return fixedDigits;
    }

    int countBall(Digits target) {
        return (int) IntStream.range(0, target.digits.size())
                .filter(i -> isDigitsContains(target.digits.get(i)) && isDifferentPosition(i, target.digits.get(i)))
                .count();
    }

    int countStrike(Digits target) {
        int strikeCount = 0;
        for (int i = 0; i < target.digits.size(); i++) {
            if (digits.get(i).equals(target.digits.get(i))) strikeCount++;
        }
        return strikeCount;
    }

    private boolean isDigitsContains(Digit digit) {
        return digits.contains(digit);
    }

    private boolean isDifferentPosition(int index, Digit digit) {
        return !digits.get(index).equals(digit);
    }

}
