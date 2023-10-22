package baseball.computer;

import baseball.domain.number.NumberConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> gameNumbers;

    public Computer() {
        this.gameNumbers = generateNumbers();
    }

    public Computer(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public void changeNumbers() {
        this.gameNumbers = generateNumbers();
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NumberConstants.NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
