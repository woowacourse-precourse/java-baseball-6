package service;

import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.exception.PlayInputException;

public class BaseBallService {
    public BaseBallService() {
        this.playInputException = new PlayInputException();
    }

    private Game game;
    private PlayInputException playInputException;
    private static final String reStart = "1";

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
