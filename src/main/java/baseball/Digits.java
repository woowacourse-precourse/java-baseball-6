package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

final class Digits {
    private final List<Digit> digits = new ArrayList<>();

    private Digits() {
    }

    static Digits generateRandomDigits() {
        Digits randomDigits = new Digits();
        while (randomDigits.digits.size() < Size.THREE.num) {
            Digit randomDigit = Digit.generateRandomDigit();
            if (!randomDigits.digits.contains(randomDigit)) randomDigits.digits.add(randomDigit);
        }
        return randomDigits;
    }

    static Digits generateFixedDigits(String input) {
        if(input.length() != Size.THREE.num) throw new IllegalArgumentException();

        Digits fixedDigits = new Digits();
        input.chars()
                .mapToObj(i -> Digit.generateFixedDigit(i - '0'))
                .peek(digit -> { if (fixedDigits.digits.contains(digit)) throw new IllegalArgumentException(); })
                .forEach(fixedDigits.digits::add);
        return fixedDigits;
    }

    int countBall(Digits target) {
        return (int) IntStream.range(0, target.digits.size())
                .filter(i -> isDigitsContains(target.digits.get(i)) && isDifferentPosition(i, target.digits.get(i)))
                .count();
    }

    int countStrike(Digits target) {
        return (int) IntStream.range(0, target.digits.size())
                .filter(i -> isSameDigitAndSamePosition(i, target.digits.get(i)))
                .count();
    }

    private boolean isDigitsContains(Digit digit) {
        return digits.contains(digit);
    }

    private boolean isDifferentPosition(int index, Digit digit) {
        return !digits.get(index).equals(digit);
    }

    private boolean isSameDigitAndSamePosition(int index, Digit digit) {
        return digits.get(index).equals(digit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digits target = (Digits) o;
        for (int i = 0; i < digits.size(); i++) if(!digits.get(i).equals(target.digits.get(i))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digits);
    }
}
