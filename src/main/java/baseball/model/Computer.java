package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumber;

    public Computer() {
    }

    public List<Integer> makeRandomNumber() {
        randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }

        return randomNumber;
    }
}
