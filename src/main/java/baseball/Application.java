package baseball;

import baseball.controller.ComputerController;
import baseball.controller.UserController;
import baseball.view.GameView;

import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean start = true;
        ComputerController computerController = new ComputerController();
        UserController userController = new UserController();

        // 게임 시작
        while(start) {
            GameView.gameStart();
            computerController.setNumbers();

            start = false;
        }
    }
}
