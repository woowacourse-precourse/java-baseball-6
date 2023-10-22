package baseball;


import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.model.GameManager;
import baseball.model.User;
import baseball.service.MatchService;
import baseball.utils.RandomNumberGenerator;
import baseball.view.Input;
import baseball.view.Print;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Computer computer = new Computer(new RandomNumberGenerator());
        User user = new User();
        GameManager gameManager = new GameManager();
        Input input = new Input();
        Print print = new Print();
        MatchService matchService = new MatchService();
        GameController gameController = new GameController(computer, user, gameManager, input, print, matchService);

        gameController.run();
    }
}
