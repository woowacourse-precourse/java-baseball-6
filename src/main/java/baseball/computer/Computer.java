package baseball.computer;

import static baseball.computer.ComputerConstants.MAX_NUMBER;
import static baseball.computer.ComputerConstants.MIN_NUMBER;
import static baseball.computer.ComputerConstants.NUMBERS_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> gameNumbers;

    public Computer() {
        this.gameNumbers = generateNumbers();
    }

    public void changeNumbers() {
        this.gameNumbers = generateNumbers();
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
