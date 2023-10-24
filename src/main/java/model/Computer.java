package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;

    public List<Integer> computerNumberGenerator() {
        computerNumbers.clear();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers() {
        computerNumbers = this.computerNumberGenerator();
    }
}
