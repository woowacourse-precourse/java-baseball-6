package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generateRandomComputerNumber() {

        List<Integer> randomComputerNumber = new ArrayList<>();

        while (randomComputerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomComputerNumber.contains(randomNumber)) {
                    randomComputerNumber.add(randomNumber);
            }
        }
        return randomComputerNumber;
    }

}
