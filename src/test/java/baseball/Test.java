package baseball;

import baseball.controller.ComputerController;
import baseball.controller.UserController;
import baseball.model.Computer;
import baseball.utility.InputDataExceptionHandler;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.print("값 입력 : ");
        InputDataExceptionHandler.validateNumbers(Console.readLine());
        System.out.println("입력 검증 완료");

        String s = GameView.userInput();
        System.out.println(s);
        System.out.println("입력 값 확인 완료");

        // 숫자생성 테스트
        UserController userController = new UserController();
        userController.setNumbers(
                GameView.userInput()
                        .chars()
                        .map(num -> num - '0')
                        .boxed()
                        .collect(Collectors.toList())
        );
        System.out.println(userController.getNumbers());

        // Test용 사용자 숫자 확인하기
        ComputerController computerController = new ComputerController();
        computerController.setNumbers();
        //System.out.println(computerController.getNumbers());
        computerController.calculate(userController.getNumbers());
        System.out.println(computerController.getBall() + ", " + computerController.getStrike());

        // 결과 테스트
        GameView.gameResult(computerController.getBall(), computerController.getStrike());

        // validator 테스트
        GameView.reGame();
    }
}
