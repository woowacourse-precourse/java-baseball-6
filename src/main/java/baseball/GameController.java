package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    Computer computer = new Computer();
    List<Integer> player = new ArrayList<>();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void start() {
        outputView.printStartMessage();
        computer.selectNumbers();
        play();
    }

    public void play() {
        GameResult gameResult;
        boolean isNotThreeStrike = true;
        while (isNotThreeStrike) {
            player.setNumbers(inputView.readNumbers());
            compareSystem = new CompareSystem(computer, player);
            gameResult = compareSystem.compare();
            outputView.printResult(gameResult);
        }
    }
}
