package baseball.service;

import baseball.Game;
import baseball.utils.RandomUtils;

public class GameService {
    int size;
    Game game;

    public void playGame() {

    }

    public void setGame(int min, int max, int size) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(min, max, size));
    }

}
