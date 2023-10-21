package process;

import camp.nextstep.edu.missionutils.Randoms;
import domain.ComputerNumber;
import validation.ValidationNumber;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberProcess {
    private List<Integer> computerNumber;

    private ComputerNumberProcess(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static ComputerNumberProcess getInstance(List<Integer> computerNumber) {
        return new ComputerNumberProcess(computerNumber);
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
