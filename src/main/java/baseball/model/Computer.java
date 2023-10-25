package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNumbers;

    public Computer() {
        selectRandomNumbers();
    }

    private void selectRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        this.computerNumbers = computerNumbers;
    }

    public int getDigit(int index) {
        return computerNumbers.get(index);
    }

    public boolean hasNumber(int number) {
        return computerNumbers.contains(number);
    }
}
