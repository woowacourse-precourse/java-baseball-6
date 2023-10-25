package baseball;


import baseball.controller.GameManager;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.NumberBaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Computer computer = new Computer();
        Player player = new Player();

        NumberBaseballService numberBaseballService = new NumberBaseballService(computer, player);
        GameManager gm = new GameManager(inputView, outputView, numberBaseballService);

        gm.startGame();
    }
}
