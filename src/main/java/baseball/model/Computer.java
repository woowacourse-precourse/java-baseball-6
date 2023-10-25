package baseball.model;

import static baseball.constant.Constant.MAX_NUMBER;
import static baseball.constant.Constant.MIN_NUMBER;
import static baseball.constant.Constant.NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final Number computerNumber;

    public Computer() {
        this.computerNumber = generateNumber();
    }

    private Number generateNumber() {
        List<Integer> digitList = new ArrayList<>();

        while (digitList.size() < NUMBER_LENGTH) {
            int digit = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!digitList.contains(digit)) {
                digitList.add(digit);
            }
        }

        return new Number(digitList);
    }

    public Number getComputerNumber() {
        return computerNumber;
    }
}
