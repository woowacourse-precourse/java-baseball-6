package baseball.controller;

import baseball.domain.entity.game.GameStatus;
import baseball.domain.dto.GameResponse;
import baseball.domain.entity.player.Computer;
import baseball.domain.entity.player.Player;
import baseball.domain.entity.player.User;
import baseball.service.GameServiceImpl;
import baseball.utils.RandomUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final GameServiceImpl gameService;
    private final OutputView outputView;
    private final InputView inputView;
    private Player user, computer;
    private GameStatus currentStatus;

    public GameController(GameServiceImpl gameService, OutputView outputView,
        InputView inputView) {
        this.gameService = gameService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printGameStart();
        play();
    }

    public void initialize() {
        currentStatus = GameStatus.CONTINUE;
        computer = Computer.of(RandomUtil.createRandomNumbers());
    }

    public void play() {
        initialize();
        do {
            outputView.printInputNumber();
            user = User.of(inputView.inputNumbers());
            GameResponse gameResponse = gameService.playGame(user, computer);
            outputView.printGameResult(gameResponse);
            currentStatus = gameResponse.getGameStatus();
        } while (currentStatus != GameStatus.OVER);
        handleGame();
    }

    public void handleGame() {
        outputView.printGameEnd();
        outputView.printGameRestart();
        GameStatus option = GameStatus.from(inputView.inputRestart());

        if (option.isOver()) {
            return;
        }
        play();
    }
}
