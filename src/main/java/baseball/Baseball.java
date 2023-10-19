package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private List<Integer> computer = new ArrayList<>();

    public void playGame() {
        generateComputerNumber();
    }

    public void generateComputerNumber() {
        while (computer.size() < 3) {
            int randomNumber = getRandomNumber();

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
