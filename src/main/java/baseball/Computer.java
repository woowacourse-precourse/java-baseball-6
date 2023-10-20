package baseball;

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

        while (digitList.size() < 3) {
            int digit = Randoms.pickNumberInRange(1, 9);

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
