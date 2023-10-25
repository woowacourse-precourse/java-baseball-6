package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = getRandomNumber();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public List<Integer> getRandomNumber() {
        List<Integer> randomList = new ArrayList<>();

        while (randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }

        return randomList;
    }
}
