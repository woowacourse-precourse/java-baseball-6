package baseball;

import baseball.model.Calculator;
import baseball.model.Computer;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Calculator calculator = new Calculator();
        GameView gameView = new GameView(computer, calculator);
    }
}
