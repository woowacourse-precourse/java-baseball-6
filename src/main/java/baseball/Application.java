package baseball;

import baseball.controller.GameController;
import baseball.utils.RandomUtils;
import baseball.view.PrintView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        PrintView printView = new PrintView();

        printView.printGameStart();
        int[] answer = RandomUtils.getRandomNumbers();

        printView.printUserInput();
        GameController.getInputNumber(answer);
    }
}
