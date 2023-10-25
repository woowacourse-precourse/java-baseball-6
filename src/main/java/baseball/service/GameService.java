package baseball.service;

import baseball.Game;
import baseball.Message.Constant.RequestMessage;
import baseball.Message.printSystemMessage;
import baseball.User;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;
    Game game;
    User user = new User();
    printSystemMessage printSystemMessage = new printSystemMessage();

    Parser parser = new Parser();


    public void setGame(int min, int max, int size) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(min, max, size));
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            printSystemMessage.printScoreMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
        game.initBaseBall();
        user.setUserNumbers(getUserNumber());
        computeScore();
    }

    private int[] getUserNumber() {
        System.out.println(RequestMessage.REQUEST_INPUT_DATA);
        String input = Console.readLine();
        return parser.parseUserInput(input, size);
    }

    private void computeScore() {
        for (int i = 0; i < size; i++) {
            compute(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }

    private void compute(int[] gameNumber, int[] userNumber, int index) {
        int pos = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[i]) {
                pos = i;
                break;
            }
        }
        checkSamePosition(index, pos);
    }

    private void checkSamePosition(int index, int pos) {
        if (index == pos) {
            game.increaseStrikeCount();
        }
        if (index != pos && pos != -1) {
            game.increaseBallCount();
        }
    }


}
