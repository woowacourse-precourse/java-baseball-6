package baseball.controller;

import baseball.controller.dto.UserNumbersDto;
import baseball.model.GameContinueNumber;
import baseball.model.GuessResult;
import baseball.model.Opponent;
import baseball.model.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private InputView inputView;
    private GameContinueNumber gameNumber;

    public GameController(final InputView inputView) {
        this.inputView = inputView;
        this.gameNumber = GameContinueNumber.createDefault();
    }

    public void startGameUntilUserWant() {
        OutputView.showStartDescription();
        while (gameNumber.canContinueGame()) {
            playGame();
        }
    }

    private void playGame() {
        Opponent opponent = Opponent.createDefaultOpponent();
        while (true) {
            OutputView.askNumbers();
            String userNumbersInput = inputView.getUserInput();
            UserNumbersDto numbersRequest = new UserNumbersDto(userNumbersInput);
            UserNumbers userNumbers = numbersRequest.toUserNumbers();

            GuessResult result = opponent.calculateResult(userNumbers);
            OutputView.showResult(result.getResult());
            if (result.isGameEnd()) {
                break;
            }
        }
        OutputView.informGameOver();
        OutputView.askContinueGame();
        String userNumberInput = inputView.getUserInput();
        gameNumber.changeNumber(userNumberInput);
    }
}
