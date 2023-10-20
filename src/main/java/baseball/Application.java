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

            while(computerController.isCorrect()) {
                // 문자열을 정수형 List로 변환하는 과정
                userController.setNumbers(
                        GameView.userInput()
                                .chars()
                                .map(num -> num - '0')
                                .boxed()
                                .collect(Collectors.toList())
                );

                GameView.gameResult(computerController.getBall(), computerController.getStrike());
            }
            
            start = false;
        }
    }
}
