package baseball.controller;

import baseball.model.GameNumber;
import baseball.model.Hint;
import baseball.model.InputEndChoice;
import baseball.model.InputEndChoice.Choice;
import baseball.model.InputNumbers;
import baseball.view.GameView;

public class BaseBall {
    private final GameView gameView;
    private final InputEndChoice inputEndChoice;
    private GameNumber gameNumber;
    private Choice gameChoice;

    public BaseBall() {
        gameView = new GameView();
        inputEndChoice = new InputEndChoice();
        setNewGame();
    }

    private void setNewGame() {
        gameNumber = new GameNumber();
        gameChoice = InputEndChoice.Choice.RESTART;
        gameNumber.createRandomNumbers();
    }

    public void startBaseBall() {
        gameView.startBaseball();
        while (gameChoice == Choice.RESTART) {
            String input = gameView.getStartInput();
            InputNumbers inputNumbers = new InputNumbers(input);
            Hint hint = new Hint(gameNumber, inputNumbers);
            if (hint.checkAnswer() != null) {
                gameView.printHintMessage(hint.checkAnswer());
                choiceEnd();
            } else {
                gameView.printHintMessage(hint.createHintMessage());
            }
        }
    }

    public void choiceEnd() {
        gameView.endBaseBall();
        String input = gameView.getEndInput();
        InputEndChoice.Choice choice = inputEndChoice.checkInputChoice(input);
        if (choice == Choice.RESTART) {
            setNewGame();
        } else {
            gameChoice = Choice.QUIT;
        }
    }
}
