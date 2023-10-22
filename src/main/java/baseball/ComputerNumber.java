package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final List<Integer> computerNumber;

    public ComputerNumber() {
        this.computerNumber = createComputerNumber();
    }

    private List<Integer> createComputerNumber() {

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
