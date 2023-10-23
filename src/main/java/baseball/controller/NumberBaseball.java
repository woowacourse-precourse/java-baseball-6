package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameManager;
import baseball.model.User;
import baseball.service.GameService;
import baseball.utils.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.ResultView;

public class NumberBaseball {

    public static GameController create() {
        Computer computer = new Computer(new RandomNumberGenerator());
        User user = new User();
        GameManager gameManager = new GameManager();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        GameService gameService = new GameService();

        return new GameController(computer, user, gameManager, inputView, resultView, gameService);
    }
}
