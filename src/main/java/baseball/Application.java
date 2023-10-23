package baseball;

import baseball.controller.Controller;
import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        Computer computer = new Computer();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Player player = new Player();

        Controller controller = new Controller(baseball, computer, inputView, outputView, player);

        outputView.startGame();
        controller.playGame();
    }
}
