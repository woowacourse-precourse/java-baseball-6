package baseball.service;

import baseball.entity.Game;
import global.utils.RandomUtil;

public class BaseballService {
    Game game;

    public void initGame(int size, int start, int end) {
        game = new Game(RandomUtil.getNumbers(size, start, end));
    }
}
