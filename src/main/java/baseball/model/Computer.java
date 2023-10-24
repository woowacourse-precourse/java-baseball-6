package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumber;

    private Computer(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static Computer createByNumber(List<Integer> computerNumber) {
        return new Computer(computerNumber);
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public int getNumberByPosition(int position) {
        return computerNumber.get(position);
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}