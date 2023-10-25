package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int LENGTH_OF_NUMBER = 3;

    List<Integer> number = new ArrayList<>();

    private static int getRandomDigit() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void setRandomNumber() {
        Set<Integer> digits = new HashSet<>();
        while (digits.size() < LENGTH_OF_NUMBER) {
            digits.add(getRandomDigit());
        }
        number = List.copyOf(digits);
    }
}