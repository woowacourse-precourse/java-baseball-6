package baseball;

import baseball.controller.ComputerController;
import baseball.controller.GameController;
import baseball.view.UserView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    private static void gameStart() {
        int[] strikeAndBall;
        ComputerController computerController = new ComputerController();
        List<Integer> baseballNumber = computerController.makeBaseballNumber();
        UserView userView = new UserView();
        GameController gameController = new GameController();

        do {
            List<Integer> userInputNumber = userView.inputBaseballNumber();
            strikeAndBall = gameController.checkNumber(baseballNumber, userInputNumber);
            userView.printStrikeAndBall(strikeAndBall);
        } while (strikeAndBall[0] != 3);

        if (userView.restartGame().equals("1")) {
            gameStart();
        } else {
            System.out.println("게임 종료");
        }

    }
}
