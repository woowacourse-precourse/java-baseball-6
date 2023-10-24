package baseball;

import baseball.controller.GameController;
import baseball.service.ComputerService;
import baseball.service.JudgeService;
import baseball.service.UserService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameController gameController = new GameController(new ComputerService(), new UserService(),
                new JudgeService());

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean check = false;

        while (!check) {
            gameController.playGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            check = gameController.checkRestartOrQuit();
        }
    }
}
