package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {

    private List<Integer> computerNumber;

    public ComputerNumberGenerator() {
        generateRandomNumbers();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
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
}
