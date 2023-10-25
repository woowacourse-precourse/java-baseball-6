package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.config.GameConfig.MAX_NUMBER;
import static baseball.common.config.GameConfig.MIN_NUMBER;
import static baseball.common.config.GameConfig.NUMBER_SIZE;

public class ComputerService {
    public Computer createComputerNumber() {
        return new Computer(createRandomNumber());
    }

    private Numbers createRandomNumber() {
        final List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < NUMBER_SIZE) {
            final int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return new Numbers(numberList);
    }
}
