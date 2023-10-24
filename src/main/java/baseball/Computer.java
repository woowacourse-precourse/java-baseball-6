package baseball;

import static baseball.Constant.MAX_NUMBER_LENGTH;
import static baseball.Constant.MAX_RANGE;
import static baseball.Constant.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String computerNumbers;

    public Computer() {
        generate();
    }

    public String getComputerNumbers() {
        return computerNumbers;
    }

    private void generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computerNumbers = convertToString(computer);
    }

    private String convertToString(List<Integer> computer) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : computer) {
            sb.append(number);
        }
        return sb.toString();
    }
}
