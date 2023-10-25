package baseball.controller;

import static baseball.controller.mapper.GuessResultMapper.resultToString;

import baseball.controller.dto.UserNumbersDto;
import baseball.model.GameContinueNumber;
import baseball.model.GuessResult;
import baseball.model.Opponent;
import baseball.model.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

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
        GuessResult result = GuessResult.createDefault();
        while (!result.isGameEnd()) {
            OutputView.askNumbers();

            UserNumbers userNumbers = getUserNumbers();
            result = opponent.calculateResult(userNumbers);
            OutputView.showResult(resultToString(result));
        }
        OutputView.informGameOver();
        OutputView.askContinueGame();
        String userNumberInput = inputView.getUserInput();
        gameNumber.changeNumber(userNumberInput);
    }

    private UserNumbers getUserNumbers() {
        UserNumbersDto userNumbersDto = new UserNumbersDto(inputView.getUserInput());
        List<String> stringNumbers = userNumbersDto.toStringNumbers();
        return UserNumbers.createUserNumbers(stringNumbers);
    }
}
