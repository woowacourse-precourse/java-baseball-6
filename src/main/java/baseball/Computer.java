package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> nums = new ArrayList<>();
    private GameResult currentResult;

    public void pickRandomNumber(int count) {
        nums.clear();
        while (nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
    }

    public GameResult getResult(List<Integer> player) {
        if (currentResult == null) {
            currentResult = new GameResult(nums, player);
            return currentResult;
        }
        currentResult.calculate(nums, player);
        return currentResult;
    }
}