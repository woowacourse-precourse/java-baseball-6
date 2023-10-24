package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;
import static baseball.util.Constants.BALL_MAX;
import static baseball.util.Constants.BALL_MIN;

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
        while (numbers.size() < BALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BALL_MIN, BALL_MAX);
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