package baseball;

import baseball.GameController.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        while (true) {
            gameController.gameInit();
            String question = gameController.gameQuestion();
            if (question.equals("2")) {
                break;
            }
        }
    }
}
