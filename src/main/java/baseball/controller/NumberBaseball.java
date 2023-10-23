package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameManager;
import baseball.model.User;
import baseball.service.GameService;
import baseball.utils.RandomNumberGenerator;
import baseball.view.Input;
import baseball.view.Print;

public class NumberBaseball {

    public static GameController create() {
        Computer computer = new Computer(new RandomNumberGenerator());
        User user = new User();
        GameManager gameManager = new GameManager();
        Input input = new Input();
        Print print = new Print();
        GameService gameService = new GameService();

        return new GameController(computer, user, gameManager, input, print, gameService);
    }
}
