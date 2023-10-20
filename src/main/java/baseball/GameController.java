package baseball;

public class GameController {
    Computer computer = new Computer();
    OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();
        computer.selectNumbers();
    }
}
