package baseball.domain;

import baseball.utils.RandomGenerateNumRange;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        makeComputerNumber();
    }

    private void makeComputerNumber() {
        while (computerNumber.size() < RandomGenerateNumRange.COUNT.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(RandomGenerateNumRange.START_RANGE_GENERATE_NUM.getValue(),
                    RandomGenerateNumRange.END_RANGE_GENERATE_NUM.getValue());
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}
