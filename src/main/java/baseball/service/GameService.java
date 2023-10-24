package baseball.service;

import baseball.domain.Baseballs;
import baseball.domain.Game;
import baseball.domain.GameScore;
import baseball.util.Converter;

public class GameService {

    private final Game game;
    private final GameScore gameScore;

    public GameService(Game game, GameScore gameScore) {
        this.game = game;
        this.gameScore = gameScore;
    }

    public void setup() {
        game.setup();
    }

    public Baseballs setPlayerBaseballs(String playerGuess) {
        return new Baseballs(Converter.convertStringToBaseballs(playerGuess));
    }

    public void calculateStrikeAndBall(Baseballs playerBaseballs) {
        Baseballs computerBaseballs = game.getComputerBaseballs();
        int balls = computerBaseballs.countBalls(playerBaseballs);
        int strikes = computerBaseballs.countStrikes(playerBaseballs);
        gameScore.setGameScore(balls, strikes);
    }

    public String generateGameResult() {
        return gameScore.generateGameResult();
    }

    public void updateGameState() {
        if (gameScore.isThreeStrike()) {
           game.setGameOver();
        }
    }

    public boolean isGameOver() {
        return game.isGameOver();
    }
}
