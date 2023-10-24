package baseball.service;

import baseball.entity.Game;
import baseball.entity.User;
import baseball.view.SystemInputMessage;
import camp.nextstep.edu.missionutils.Console;
import global.utils.ParseUtil;
import global.utils.RandomUtil;

public class BaseballService {

    int size;
    Game game;
    User user;
    ParseUtil parseUtil;

    public void initGame(int size, int start, int end) {
        SystemInputMessage.showInitGameMessage();
        this.size = size;
        game = new Game(RandomUtil.getNumbers(size, start, end));
    }


    public void startGame() {
        int strike = 0;
        while (strike != 3) {
            play();
        }
    }

    private void play() {
        SystemInputMessage.showInputMessage();
        game.initGame();
        user.setUserNumbers(getUserNumbers());
    }

    private int[] getUserNumbers() {
        String input = Console.readLine();
        return parseUtil.parseInput(input, size);
    }
}
