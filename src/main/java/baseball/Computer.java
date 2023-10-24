package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    List<Integer> number = new ArrayList<>();

    public static int getRandomDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void setRandomNumber() {
        Set<Integer> digits = new HashSet<>();
        while (digits.size() < 3) {
            digits.add(getRandomDigit());
        }
        this.number = List.copyOf(digits);
    }
}