package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
public class GameNumberGenerator {
    public List<Integer> generateNumber() {
        List<Integer> gameNumber = new ArrayList<>();
        while (gameNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!gameNumber.contains(randomNumber)) {
                gameNumber.add(randomNumber);
            }
        }
        return gameNumber;
    }
}
