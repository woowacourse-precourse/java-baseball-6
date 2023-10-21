package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    GameService() {
    }

    public List<Integer> makeRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumberInt = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumberInt)) {
                randomNumberList.add(randomNumberInt);
            }
        }
        return randomNumberList;
    }

    public int[] compareGuessToRandom(List<Integer> userGuessNumber, List<Integer> randomNumber) {
        int[] ballAndStrike = new int[2];
        for (int index = 0; index < userGuessNumber.size(); index++) {
            int guessNumber = userGuessNumber.get(index);
            if (!randomNumber.contains(guessNumber)) {
                continue;
            }
            int randNumIndex = randomNumber.indexOf(guessNumber);
            if (randNumIndex == index) {
                ballAndStrike[1]++;
            } else if (randNumIndex != index) {
                ballAndStrike[0]++;
            }
        }
        return ballAndStrike;
    }
}
