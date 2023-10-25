package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.global.utils.NumberDefinition.*;

public class Computer {
    private final List<Integer> computerThreeNumbers;

    public Computer() {
        this.computerThreeNumbers = new ArrayList<>();
    }

    public void generateThreeNumber() {
        clearNumbers();
        while(computerThreeNumbers.size() < DIGIT_CNT.getNumber()) {
            Integer number = Randoms.pickNumberInRange(START_NUMBER.getNumber(), END_NUMBER.getNumber());

            if(!computerThreeNumbers.contains(number)) {
                computerThreeNumbers.add(number);
            }
        }
    }

    public List<Integer> getComputerThreeNumbers() {
        return computerThreeNumbers;
    }

    public void clearNumbers() {
        if(this.computerThreeNumbers.size() > 0) {
            this.computerThreeNumbers.clear();
        }
    }
}
