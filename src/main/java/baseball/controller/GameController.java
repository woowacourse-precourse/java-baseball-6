package baseball.controller;

import baseball.model.Game;
import baseball.view.GameView;

import java.util.List;

public class GameController {
    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";
    private static final String INVALID_ANSWER_MESSAGE = "1 또는 2를 입력하세요.";

    private final Game game;
    private final ComputerController computerController;
    private final Validation validation;
    private final GameView gameView;

    public GameController() {
        this.computerController = new ComputerController();
        this.game = new Game();
        this.validation = new Validation();
        this.gameView = new GameView();
    }

    public void startGame(){
        boolean isIng = true;

        while(isIng){
            gameView.startGameMessage();
            computerController.createRandomNumber(game);
            guessAnswer();
            isIng = restartOrEndGame();
        }

    }

    public void guessAnswer(){
        boolean isCorrect = false;

        while (!isCorrect){
            game.setUserInput(gameView.inputNumber());
            List<Integer> userNumbers = validation.checkValidation(game.getUserInput());
            game.setUserNumbers(userNumbers);

            isCorrect = computerController.compareAndCountStrike(game);
            if (isCorrect){
                gameView.successGameMessage();
            }

        }
    }

    public boolean restartOrEndGame(){
        String input = gameView.restartOrEndMessage();
        if (input.equals(RESTART_GAME)){
            return true;
        } else if (input.equals(END_GAME)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_ANSWER_MESSAGE);
    }
}
