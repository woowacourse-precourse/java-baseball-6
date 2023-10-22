package baseball.Service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.RandomUtils;

public class GameService {
    int size;

    User user = new User();
    Game game = new Game();
    RandomUtils randomUtils = new RandomUtils();

    public void setGame(int size, int startInclusive, int endInclusive) {
        this.size = size;
        randomUtils.getRandomNumbers(size, startInclusive, endInclusive);
    }

    private static void compare() {

    }
}
