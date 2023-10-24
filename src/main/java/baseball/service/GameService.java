package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.util.Parser;
import baseball.util.RandomUtil;
import baseball.view.SystemGameMessage;
import baseball.view.SystemInputMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;
    Game game;
    User user = new User();
    Parser parser = new Parser();
    SystemGameMessage systemGameMessage = new SystemGameMessage();

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new Game(RandomUtil.getRandomNumbers(size, start, end));
    }

    private void play() {
        game.initGame();
        user.setUserNumbers(getUserNumber());
        calcScore();
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            systemGameMessage.printScoreMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private int[] getUserNumber() throws IllegalArgumentException {
        SystemInputMessage.requestInputData();
        String input = Console.readLine();
        return parser.parseUserInput(input, size);
    }

    private void calc(int[] gameNumber, int[] userNumber, int idx) {
        int tmp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[idx]) {
                tmp = i;
                break;
            }
        }
        addCount(idx, tmp);
    }

    private void calcScore() {
        for (int i = 0; i < size; i++) {
            calc(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }

    private void addCount(int idx, int tmp) {
        if (tmp != idx && tmp != -1) {
            game.addBallCount();
        }
        if (tmp == idx) {
            game.addStrikeCount();
        }
    }
}
