package service;

import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.exception.PlayInputException;

public class BaseBallService {
    private static final String reStart = "1";
    private Game game;
    private PlayInputException playInputException;
    public BaseBallService() {
        this.playInputException = new PlayInputException();
    }

    public void reStartGame(){
        this.game = new Game();
    }
    public GameResult compareNumber(String userInput) {
        game.userInput(userInput);
        game.countResult();
        return game.getGameResult();
    }
    public boolean reStart(String userInput) throws IllegalArgumentException {
        if(!playInputException.isValid(userInput)){
            throw new IllegalArgumentException();
        }
        return userInput.equals(reStart);
    }

}
