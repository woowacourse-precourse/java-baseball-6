package baseball.game;

import static baseball.utils.RandomNumberGenerator.generateRandomUniqueThreeNumbers;

import baseball.io.UserIOHandler;
import baseball.model.Score;
import java.util.List;

public class BaseballGame {
    private static final String INVALID_INPUT_MESSAGE = "잘못된 값을 입력하셨습니다.";
    private static final String OPTION_RESTART = "1";
    private static final String OPTION_QUIT = "2";
    private final BaseballScoreEvaluator scoreEvaluator = new BaseballScoreEvaluator();
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
        currentGameState = GameState.RUNNING;

        while (currentGameState != GameState.ROUND_WON) {
            attemptSingleRound();
        }
    }

    private void attemptSingleRound() {
        String userInput = userIOHandler.readUserInputForNumbers();
        List<Integer> userGuessNumbers = userIOHandler.validateAndParseUserInput(userInput);
        Score currentScore = scoreEvaluator.evaluate(generatedNumbers, userGuessNumbers);
        determineGameStatusBasedOnScore(currentScore);
    }

    private void determineGameStatusBasedOnScore(Score currentScore) {
        userIOHandler.displayRoundOutcome(currentScore);
        if (currentScore.isGameWon()) {
            currentGameState = GameState.ROUND_WON;
        }
    }

    private void promptForGameRestart() {
        String userInput = userIOHandler.readUserInputForRestart();
        if (OPTION_QUIT.equals(userInput)) {
            currentGameState = GameState.STOPPED;
        } else if (!OPTION_RESTART.equals(userInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public enum GameState {
        RUNNING, STOPPED, ROUND_WON
    }
}
