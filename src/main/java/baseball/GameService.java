package baseball;

import java.util.List;

public class GameService {

    GameService() {
    }

    public int[] compareGuessToRandom(List<Integer> userGuessNumber, RandomNumber randomNumber) {
        int[] ballAndStrike = new int[2];
        for (int index = 0; index < userGuessNumber.size(); index++) {
            int guessNumber = userGuessNumber.get(index);
            if (!randomNumber.isNumberContain(guessNumber)) {
                continue;
            }
            int randNumIndex = randomNumber.findIndex(guessNumber);
            if (randNumIndex == index) {
                ballAndStrike[1]++;
            } else if (randNumIndex != index) {
                ballAndStrike[0]++;
            }
        }
        return ballAndStrike;
    }
}
