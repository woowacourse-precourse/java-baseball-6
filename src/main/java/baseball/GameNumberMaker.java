package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameNumberMaker {
    private final GameNumber gameNumber;

    public GameNumberMaker() {
        this.gameNumber = new GameNumber();
    }

    public List<Integer> makeGameNumber() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        gameNumber.setGameNumber(numbers);

        return gameNumber.getGameNumber();
    }
}
