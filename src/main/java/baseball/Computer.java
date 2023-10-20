package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    // Computer가 어떤 숫자를 가지고 있는지 모르게 하기 위해
    private final List<Integer> threeNumbers = new ArrayList<>();

    public Computer() {
        while (threeNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeNumbers.contains(randomNumber)) {
                threeNumbers.add(randomNumber);
            }
        }
    }

    public String toString() {
        return "Computer{" +
                "threeNumbers=" + threeNumbers +
                '}';
    }
}