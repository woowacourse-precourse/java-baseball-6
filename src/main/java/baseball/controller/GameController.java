package baseball.controller;

import baseball.model.dto.Score;
import baseball.model.entity.BaseballNumber;
import baseball.model.entity.Computer;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutView;

public class GameController {
    private final InputView inputView = new InputView();
    private final GameService gameService = new GameService();
    private OutView outView = new OutView();
    public void startGame() {

    }

    private void playGame() {
        gameService.startGame();
        calculateResult(getInputNumbers());
    }

    private void calculateResult(BaseballNumber inputNumbers) {
        Score score = gameService.calculateResult(inputNumbers);
        outView.printResult(score);
        if (score.isGameEnd()) {
            outView.printGameEnd();
            return;
        }
        calculateResult(getInputNumbers());
    }

    private BaseballNumber getInputNumbers() {
        String input = inputView.inputNumbers();
        return new BaseballNumber(input);
    }
}
