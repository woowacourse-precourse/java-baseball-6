package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String computerNumber;

    public Computer() {
        setComputerNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber() {
        List<String> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String randomStr = String.valueOf(randomNumber);
            if (!computer.contains(randomStr)) {
                computer.add(randomStr);
            }
        }

        this.computerNumber = String.join("", computer);
    }
}
