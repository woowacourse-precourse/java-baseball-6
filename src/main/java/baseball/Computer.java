package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computer;

    public Computer() {
        computer = new ArrayList<>();
    }

    public void generateComputerNumber(final int minNumber, final int maxNumber) {
        if (!computer.isEmpty()) {
            computer.clear();
        }

        while (computer.size() < 3) {
            int randomNumber = getRandomNumber(minNumber, maxNumber);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private int getRandomNumber(final int minNumber, final int maxNumber) {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }

    public int getComputerNumber(final int index) {
        return computer.get(index);
    }

    public boolean isContainsNumber(final int userNumber) {
        return computer.contains(userNumber);
    }
}
