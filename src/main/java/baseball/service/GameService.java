package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    int size;
    Game game;
    User user = new User();
    Parser parser = new Parser();
    SystemMessage systemMessage = new SystemMessage();

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(size, start, end));
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            systemMessage.printScoreMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
        game.initBaseBall();
        user.setUserNumbers(getUserNumber());
        calScore();
    }

    private int[] getUserNumber() throws IllegalArgumentException {
        RequestInput.requestInputData();
        String input = Console.readLine();
        return parser.parseUserInput(input, size);
    }

    private void calScore() {
        for (int i = 0; i < size; i++) {
            calculate(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }

    private void calculate(int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        incrementCount(index, temp);
    }

    private void incrementCount(int index, int temp) {
        if (temp != index && temp != -1) {
            game.incrementBallCount();
        }
        if (temp == index) {
            game.incrementStrikeCount();
        }
    }
}
