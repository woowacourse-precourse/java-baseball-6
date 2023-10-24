package baseball;

import baseball.controller.GameController;
import baseball.controller.UserController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        UserController userController = new UserController();

        gameController.startGame();

        boolean isEnd = false;
        while(!isEnd) {
            gameController.makeNumber();

            boolean success = false;
            while(!success){
                String userNumber = userController.numberInput();
                success = gameController.matchNumber(userNumber);
            }
            String inputNumberString = userController.endTypeInput();
            int inputNumber = Integer.parseInt(inputNumberString);

            isEnd = gameController.endGame(inputNumber);
        }
    }
}
