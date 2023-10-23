package baseball.service;

import baseball.Parser;
import baseball.RandomNum;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.view.RequestData;
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
        game = new Game(RandomNum.getRandomNumbers(size, start, end));
    }
    public void play() {
        int strike = 0;
        while(strike != 3) {
            game.init();
            user.setUserNumbers(getUserNumber());
            giveScore();
            systemMessage.printScore(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }
    public int[] getUserNumber() {
        RequestData.requestInputData();
        String input = Console.readLine();
        return parser.parseUserInput(input, size);
    }
    public void giveScore() {
        for (int i = 0; i < size; i++) {
            score(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }
    public void score(int[] gameNumbers, int[] userNumbers, int index) {
        int temp = -1;
        for(int i = 0; i < size; i++) {
            if(userNumbers[index] == gameNumbers[i]) {
                temp = i;
                break;
            }
        }
        countScore(index, temp);
    }
    public void countScore(int index, int temp) {
        if (temp != index && temp != -1) {
            game.addBallCount();
        }
        if (temp == index) {
            game.addStrikeCount();
        }
    }
}
