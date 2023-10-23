package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Computer {

    ComputerNumberHashMap computerNumberHashMap;

    public void createNumbers() {
        this.computerNumberHashMap = new ComputerNumberHashMap(createRandomNumbers());
    }

    private HashMap<Integer, Integer> createRandomNumbers() {
        HashMap<Integer, Integer> randomNumbers = new HashMap<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.containsKey(randomNumber)) {
                randomNumbers.put(randomNumber, randomNumbers.size());
            }
        }
        return randomNumbers;
    }

    public ComputerNumberHashMap getComputerNumbers() {
        return computerNumberHashMap;
    }

}
