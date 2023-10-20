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
        player = inputView.readNumbers();
    }
}
