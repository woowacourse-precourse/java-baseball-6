package baseball.domain;

import baseball.util.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNums;

    public void assignComputerNums() {
        computerNums = generateRandomNums();
    }

    public List<Integer> generateRandomNums() {
        List<Integer> randomNums = new ArrayList<>();

        while (randomNums.size() < GameConstants.DIGIT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_RANGE_NUMBER,
                    GameConstants.MAX_RANGE_NUMBER);

            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }

        return randomNums;
    }

    public boolean isSameNumber(int number, int index) {
        if (number != computerNums.get(index)) {
            return false;
        }

        return true;
    }

    public boolean isContainNumber(int number) {
        if (!computerNums.contains(number)) {
            return false;
        }

        return true;
    }
}
