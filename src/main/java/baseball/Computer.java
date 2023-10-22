package baseball;

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
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
