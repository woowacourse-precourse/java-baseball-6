package baseball;

import java.util.List;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean startGame = true;
        while (startGame) {
            startGame();
        }
    }

    static void startGame() {
        OutputView.printStartMessage();
        List<Integer> computer = BaseballNumberGenerator.generateThreeDigits();
    }
}
