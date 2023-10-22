package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final static int NUMBER_LENGTH = 3;
    private final static int START_NUMBER = 1;
    private final static int FINAL_NUMBER = 9;

    private final List<Integer> computerNumber;

    public ComputerNumber() {
        this.computerNumber = createComputerNumber();
    }

    private List<Integer> createComputerNumber() {

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, FINAL_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
