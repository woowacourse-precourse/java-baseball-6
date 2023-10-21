package baseball;

import java.util.ArrayList;
import java.util.List;

final class Digits {
    private List<Digit> digits;

//    Digits() {
//        while (digits.size() < Size.THREE.num) {
//            Digit randomDigit = new Digit();
//            if (!digits.contains(randomDigit)) digits.add(randomDigit);
//        }
//    }

    private Digits() {
    }

    static Digits generateRandomDigits() {
        Digits random = new Digits();
        random.digits = new ArrayList<>();
        while (random.digits.size() < Size.THREE.num) {
            Digit randomDigit = new Digit();
            if (!random.digits.contains(randomDigit)) random.digits.add(randomDigit);
        }
//        System.out.println(random.digits.get(0).digit + " " + random.digits.get(1).digit + " " + random.digits.get(2).digit);
        return random;
    }

    //TODO : 정적팩터리로?
    Digits(String input) {
        if(input.length() != Size.THREE.num) throw new IllegalArgumentException();
        digits = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Digit digit = new Digit(input.charAt(i));
            if (digits.contains(digit)) throw new IllegalArgumentException();
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

    int countStrike(Digits target) {
        int strikeCount = 0;
        for (int i = 0; i < target.digits.size(); i++) {
            if (digits.get(i).equals(target.digits.get(i))) strikeCount++;
        }
        return strikeCount;
    }
}
