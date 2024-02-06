package baseball.model;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final List<Integer> number;

    public ComputerNumber() {
        this.number = generateComputerNumber();
    }


    private List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < Constant.RIGHT_NUMBER_LENGTH) {
            addRandomNumber(computerNumber);
        }
        return computerNumber;
    }

    public List<Integer> getNumber() {
        return number;
    }

    private void addRandomNumber(List<Integer> computerNumber) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

}