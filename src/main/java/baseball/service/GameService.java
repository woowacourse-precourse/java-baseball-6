package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
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

    public void setGame() {
        gameOutputView.printStartGame();
        game = new Game(randomUtils.getGameNumber());
        System.out.println(game.getGameNumber()[0] + " " + game.getGameNumber()[1] + " " + game.getGameNumber()[2]);
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

    public void computeScore(int[] gameNumber, int[] userNumber) {
        for(int i=0; i<gameNumber.length; i++) {
            compareNumber(gameNumber,userNumber,i);
        }
    }

    public void compareNumber(int[] gameNumber, int[] userNumber, int index) {
        for(int i=0; i<gameNumber.length; i++) {
            if(userNumber[index] == gameNumber[i] && index != i) {
                game.increaseBall();
                break;
            }
            if(userNumber[index] == gameNumber[i] && index == i) {
                game.increaseStrike();
                break;
            }
        }
    }
}