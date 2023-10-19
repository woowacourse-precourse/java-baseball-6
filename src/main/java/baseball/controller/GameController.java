package baseball.controller;

import baseball.domain.GameStatus;
import baseball.domain.RandomNumber;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private InputView inputView;
    private OutputView outputView;
    private GameService gameService;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void playGame() {
        RandomNumber randomNumber = new RandomNumber();
        List<Integer> inputNumber = inputView.getInputNumber();
        GameStatus gameStatus = new GameStatus();
        GameStatus gamestatus = gameService.compareNumber(randomNumber, inputNumber, gameStatus);
        outputView.printGameResult(gamestatus);
    }
}
