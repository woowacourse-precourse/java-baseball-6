package baseball.service;

import baseball.constant.GameConstants;
import baseball.domain.Computer;
import baseball.domain.GameResult;
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

    public void checkGuessNumbers(List<Integer> playerNums, GameResult gameResult) {
        for (int i = 0; i < playerNums.size(); i++) {
            int comparisonNumber = playerNums.get(i);

            // 같은 수이면서 같은 자리인지 검사
            if (computer.isSameNumber(comparisonNumber, i)) {
                gameResult.increaseStrikeCount();

                continue;
            }

            // 같은 수가 있는지 검사
            if (computer.isContainNumber(comparisonNumber)) {
                gameResult.increaseBallCount();
            }
        }
    }
}
