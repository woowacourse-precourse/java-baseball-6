package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    private List<Integer> computerNumber;

    public ComputerNumbers() {
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(3);
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (numbers.contains(randomNumber)) {
                continue;
            }
            numbers.add(randomNumber);
        }
        this.computerNumber = numbers;
    }

    public void reset() {
        generateRandomNumbers();
    }


    public boolean isBall(int target, int index) {
        return computerNumber.contains(target) && !computerNumber.get(index).equals(target);
    }

    public boolean isStrike(int target, int index) {
        return computerNumber.get(index) == target;
    }
}
