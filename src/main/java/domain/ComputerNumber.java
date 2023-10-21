package domain;

import camp.nextstep.edu.missionutils.Randoms;
import validation.ValidationNumber;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNumber;

    private ComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static ComputerNumber getInstance(List<Integer> computerNumber) {
        return new ComputerNumber(computerNumber);
    }

    public List<Integer> getRandomNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        ValidationNumber.validateNumbers(computerNumber);
        return computerNumber;
    }
}
