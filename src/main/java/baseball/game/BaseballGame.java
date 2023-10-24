package baseball.game;


import static baseball.utils.RandomNumberGenerator.generateRandomUniqueThreeNumbers;

import baseball.io.UserIOHandler;
import java.util.List;

public class BaseballGame {
    private final UserIOHandler userIOHandler = new UserIOHandler();
    private List<Integer> generatedNumbers;
    private GameState currentGameState = GameState.RUNNING;

    public void startGame() {
        userIOHandler.displayGameStartMessage();
        executeGameLoop();
    }

    private void executeGameLoop() {
        while (currentGameState != GameState.STOPPED) {
            generateGameNumbers();
            playUntilRoundWon();
            promptForGameRestart();
        }
    }

    private void generateGameNumbers() {
        generatedNumbers = generateRandomUniqueThreeNumbers();
    }

    private void playUntilRoundWon() {
        // todo: play until round won
    }


    private void promptForGameRestart() {
        // todo: prompt for game restart
    }

    public enum GameState {
        RUNNING, STOPPED, ROUND_WON
    }
}
