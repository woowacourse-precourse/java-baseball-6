package baseball;

import baseball.model.GameNumber;
import baseball.model.Opponent;
import baseball.model.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private GameNumber gameNumber;

    private GameController() {
        this.gameNumber=GameNumber.createDefault();
    }

    public void startGameUntilUserWant() {
        OutputView.showStartDescription();
        while(gameNumber.canContinueGame()){
            playGame();
        }
    }

    private void playGame() {
        Opponent opponent=new Opponent();
        UserNumbers userNumbers=new UserNumbers();
        while(!opponent.isUserCorrect(userNumbers)){
            OutputView.askNumbers();
            String userNumbersInput=InputView.getUserInput();
            userNumbers.changeNumbers(Integer.parseInt(userNumbersInput));
            opponent.calculateResult(userNumbers);
            OutputView.showResult();
        }
        OutputView.informGameOver();
        OutputView.askContinueGame();
        String userNumberInput=InputView.getUserInput();
        gameNumber.changeNumber(Integer.parseInt(userNumberInput));
    }

}
