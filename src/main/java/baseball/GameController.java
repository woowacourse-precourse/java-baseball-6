package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private UiGenerator uiGenerator;
    private RandomBallGenerator randomBallGenerator;
    private HintJudge hintJudge;
    private UserInputHandler userInputHandler;
    private List<Integer> targetBallList = new ArrayList<>();
    private Boolean isGameFinished;

    public GameController() {
        uiGenerator = new UiGenerator();
        randomBallGenerator = new RandomBallGenerator();
        userInputHandler = new UserInputHandler();
        hintJudge = new HintJudge();
        isGameFinished = false;
        uiGenerator.printGameStart();
    }

    private void newGameSetting() {
        targetBallList.clear();
        targetBallList = randomBallGenerator.generateRandomNumber();
    }

    public void startNewGame() {
        newGameSetting();
        while (!isGameFinished) {
            playGuess();
        }
    }


    private GuessStatus askUserInput() {
        uiGenerator.printRequestUserPrediction();
        List<Integer> currentGuess = userInputHandler.getUserGuess();
        return hintJudge.calculateStrikeBall(currentGuess, targetBallList);
    }

    private void playGuess() {
        GuessStatus guessStatus = askUserInput();
        uiGenerator.printStrikeBall(guessStatus);
        if (guessStatus.isThreeStrike()) {
            endCurrentGame();
            Boolean isRestart = userInputHandler.askUserRestart();
            if (!isRestart) {
                isGameFinished = true;
                return;
            }
            startNewGame();
        }
    }

    private void endCurrentGame() {
        uiGenerator.printEndCurrentGameAndAskNewGame();
    }

}
