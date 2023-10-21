package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private int computerNumber;
    private List<Integer> computerNumbers;

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumber() {
        computerNumber = makeNumber();
    }

    public int getComputerNumber() {
        return computerNumber;
    }

    private int makeNumber() {
        computerNumbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                sb.append(randomNumber);
                computerNumbers.add(randomNumber);
            }
        }
        return Integer.parseInt(String.valueOf(sb));
    }
}
