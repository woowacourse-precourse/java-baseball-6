package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private final List<Integer> randomNumber;

    public RandomNumber() {
        this.randomNumber = create();
    }

    public List<Integer> create() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        Collections.shuffle(computer);
        return computer;
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public boolean isStrike(Integer inputNumber, int index) {
        return this.randomNumber.get(index).equals(inputNumber);
    }

    public boolean isBall(Integer inputNumber, int index) {
        return this.randomNumber.contains(inputNumber) && !this.randomNumber.get(index).equals(inputNumber);
    }
}
