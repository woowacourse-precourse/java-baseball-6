package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.global.utils.NumberDefinition.END_NUMBER;
import static baseball.global.utils.NumberDefinition.START_NUMBER;

public class Computer {
    private final List<Integer> computerThreeNumbers;

    public Computer() {
        this.computerThreeNumbers = generateThreeNumber();
    }

    public List<Integer> getComputerThreeNumbers() {
        return computerThreeNumbers;
    }

    private List<Integer> generateThreeNumber() {
        List<Integer> computerThreeNumbers = new ArrayList<>();
        while(computerThreeNumbers.size() < 3) {
            Integer number = Randoms.pickNumberInRange(START_NUMBER.getNumber(), END_NUMBER.getNumber());

            if(!computerThreeNumbers.contains(number)) {
                computerThreeNumbers.add(number);
            }
        }
        return computerThreeNumbers;
    }
}
