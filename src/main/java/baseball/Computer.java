package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computer;

    public Computer() {
        computer = new ArrayList<>();
    }

    public void generateComputerNumber() {
        if (!computer.isEmpty()) {
            computer.clear();
        }

        while (computer.size() < 3) {
            int randomNumber = getRandomNumber();

            if (!isContainsNumber(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(Baseball.MIN_NUMBER, Baseball.MAX_NUMBER);
    }

    public int getComputerNumber(final int index) {
        return computer.get(index);
    }

    public boolean isContainsNumber(final int number) {
        return computer.contains(number);
    }
}
