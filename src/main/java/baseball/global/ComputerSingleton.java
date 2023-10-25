package baseball.global;

import static baseball.global.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerSingleton {

    private final List<Integer> computerNumbers;

    private ComputerSingleton() {
        computerNumbers = new ArrayList<>();
        generateComputerNumbers();
    }

    public static ComputerSingleton getInstance() {
        return ComputerSingletonHolder.INSTANCE;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void resetComputerNumbers() {
        computerNumbers.clear();
        generateComputerNumbers();
    }

    private void generateComputerNumbers() {
        while (computerNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    private static class ComputerSingletonHolder {
        private static final ComputerSingleton INSTANCE = new ComputerSingleton();
    }
}
