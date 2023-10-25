package baseball.service;

import baseball.model.Game;
import baseball.model.User;
import baseball.utils.Checker;
import baseball.utils.NumberGenerator;
import baseball.view.GameStartMessage;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;
    Game game;
    User user = new User();
    Checker checker = new Checker();
    SystemMessage systemMessage = new SystemMessage();

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new Game(NumberGenerator.getRandomNumbers(size, start, end));
    }

    public void playGame() {
        GameStartMessage.printGameStartMessage();
        int strike = 0;
        while (strike != 3) {
            play();
            systemMessage.printScoreMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
        game.initBaseBall();
        game.setStrikeCount(0);
        game.setBallCount(0);
        user.setUserNumbers(getUserNumber());
        computeScore();
    }

    private int[] getUserNumber() throws IllegalArgumentException {
        RequestInput.requestInputData();
        String input = Console.readLine();
        return checker.checkUserInput(input, size);
    }

    private void computeScore() {
        for (int i = 0; i < size; i++) {
            compute(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }

    private void compute(int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        incCount(index, temp);
    }

    private void incCount(int index, int temp) {
        if (temp != index && temp != -1) {
            game.incBallCount();
        }
        if (temp == index) {
            game.incStrikeCount();
        }
    }
}


