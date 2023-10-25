package baseball;

import baseball.controller.GameController;
import baseball.model.numbers.AnswerGenerator;
import baseball.model.numbers.RandomAnswerGenerator;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new RandomAnswerGenerator());
        gameController.start();
    }
}
