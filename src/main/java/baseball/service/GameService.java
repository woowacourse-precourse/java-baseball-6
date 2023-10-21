package baseball.service;

import baseball.constant.GameConstants;
import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Computer computer;

    public void assignComputerNums() {
        List<Integer> computerNums = generateRandomNums();
        computer = new Computer(computerNums);
    }

    public List<Integer> generateRandomNums() {
        List<Integer> randomNums = new ArrayList<>();

        while (randomNums.size() < GameConstants.FIXED_DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_RANGE_NUMBER,
                    GameConstants.MAX_RANGE_NUMBER);
            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }

        return randomNums;
    }
}
