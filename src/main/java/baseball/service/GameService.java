package baseball.service;

import baseball.model.Game;
import baseball.model.User;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.GameInputView;
import baseball.view.GameOutputView;

public class GameService {
    Game game;
    User user = new User();
    Parser parser = new Parser();
    RandomUtils randomUtils = new RandomUtils();
    GameInputView gameInputView = new GameInputView();
    GameOutputView gameOutputView = new GameOutputView();
    boolean[] isStrike;

    public void setGame() {
        gameOutputView.printStartGame();
        game = new Game(randomUtils.getGameNumber());
    }

    public void playGame() {
        int strike = 0;

        while(strike != 3){
            game.initGame();
            gameOutputView.printInputNumber();
            user.setUserNumber(parser.parseUserInput(gameInputView.getUserInput(),3));
            computeScore(game.getGameNumber(), user.getUserNumber());
            gameOutputView.printResult(game.getStrike(), game.getBall());
            strike = game.getStrike();
        }
    }

    public void endGame() {
        gameOutputView.printGameOver();
    }

    public int retryGame() throws IllegalArgumentException{
        gameOutputView.printRetryGame();
        int number = parser.parseUserInput(gameInputView.getUserInput(),1)[0];
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    public void computeScore(int[] gameNumber, int[] userNumber) {
        isStrike = new boolean[3];
        for(int i=0; i<gameNumber.length; i++) {
            compareNumber(gameNumber,userNumber,i);
        }
    }

    public void compareNumber(int[] gameNumber, int[] userNumber, int index) {
        for(int i=0; i<gameNumber.length; i++) {
            if(userNumber[index] == gameNumber[i] && index == i) {
                game.increaseStrike();
                isStrike[index] = true;
                break;
            }
            if(userNumber[index] == gameNumber[i] && index != i && !isStrike[i]) {
                game.increaseBall();
                break;
            }
        }
    }
}