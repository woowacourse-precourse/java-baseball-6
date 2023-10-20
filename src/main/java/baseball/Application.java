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
        GameView.gameStart();

        // 게임 시작
        while(start) {
            // 랜덤한 컴퓨터 숫자 생성
            computerController.setNumbers();
            // 정답일 때까지 반복
            while(!computerController.isCorrect()) {
                // 문자열 -> 정수형 List
                userController.setNumbers(
                        GameView.userInput()
                                .chars()
                                .map(num -> num - '0')
                                .boxed()
                                .collect(Collectors.toList())
                );

                // 사용자 입력 -> 계산 -> 결과
                computerController.calculate(userController.getNumbers());
                GameView.gameResult(computerController.getBall(), computerController.getStrike());
            }

            start = GameView.reGame();
        }
    }
}
