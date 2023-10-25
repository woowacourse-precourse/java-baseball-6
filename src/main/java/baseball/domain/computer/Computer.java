package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.global.utils.NumberDefinition.*;

public class Computer {
    private List<Integer> computerThreeNumbers;

    public Computer() {
        this.computerThreeNumbers = new ArrayList<>();
    }

    public void generateThreeNumber() {
        List<Integer> threeNumber = new ArrayList<>();
        while(threeNumber.size() < DIGIT_CNT.getNumber()) {
            Integer number = Randoms.pickNumberInRange(START_NUMBER.getNumber(), END_NUMBER.getNumber());

            if(!threeNumber.contains(number)) {
                threeNumber.add(number);
            }
        }
        this.computerThreeNumbers = threeNumber;
    }

    public List<Integer> getComputerThreeNumbers() {
        return computerThreeNumbers;
    }
}
