package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addRandomNumber(computerNumbers, randomNumber);
        }
        return computerNumbers;
    }

    private static boolean isDuplicated(List<Integer> computerNumbers, int randomNumber) {
        return computerNumbers.contains(randomNumber);
    }

    private static void addRandomNumber(List<Integer> computerNumbers, int randomNumber) {
        if (!isDuplicated(computerNumbers, randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }
}
