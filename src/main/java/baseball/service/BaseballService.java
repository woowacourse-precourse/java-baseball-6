package baseball.service;

import baseball.entity.Game;
import baseball.entity.User;
import baseball.view.SystemInputMessage;
import baseball.view.SystemOutputMessage;
import camp.nextstep.edu.missionutils.Console;
import static global.Constants.*;
import global.utils.ParseUtil;
import global.utils.RandomUtil;

public class BaseballService {

    int size;
    Game game;
    User user;
    ParseUtil parseUtil;
    SystemOutputMessage systemOutputMessage = new SystemOutputMessage();

    public void initGame(int size, int start, int end) {
        SystemInputMessage.showInitGameMessage();
        this.size = size;
        game = new Game(RandomUtil.getNumbers(size, start, end));
    }


    public void startGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            systemOutputMessage.showScoreMessage(game.getStrikeCount(), game.getBallCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
        SystemInputMessage.showInputMessage();
        game.initGame();
        user.setUserNumbers(getUserNumbers());
        calculateScore(game.getGameNumbers(), user.getUserNumbers());
    }

    private int[] getUserNumbers() {
        String input = Console.readLine();
        return parseUtil.parseInput(input, size);
    }

    private void calculateScore(int[] gameNumbers, int[] userNumbers) {
        for (int i = 0; i < size; i++) {
            calculate(gameNumbers, userNumbers, i);
        }
    }

    private void calculate(int[] gameNumbers, int[] userNumbers, int idx) {
        int temp = -1;
        for (int i = 0; i < size; i++) {
            if (gameNumbers[i] == userNumbers[idx]) {
                temp = i;
                break;
            }
        }
        increaseCount(idx, temp);
    }

    private void increaseCount(int idx, int temp) {
        if(idx == temp) game.increaseStrikeCount();
        if(idx != temp && temp != -1) game.increaseBallCount();
    }

    public void endGame() {
        systemOutputMessage.showGameOverMessage();
    }

    public boolean askRetry() {
        SystemInputMessage.showRetryMessage();
        return getInputNumber() == RETRY;
    }

    private int getInputNumber() {
        int input = Integer.parseInt(Console.readLine());
        if (input == 0 || input > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
